package com.revature.SynergyFitness.controllers;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.SynergyFitness.Beans.Users;
import com.revature.SynergyFitness.exceptions.UserNameAlreadyExistsException;
import com.revature.SynergyFitness.services.TrainerService;
import com.revature.SynergyFitness.services.UserService;
import com.revature.SynergyFitness.exceptions.IncorrectCredentialsException;

@RestController // basically puts @ResponseBody over ALL methods - no returning views
@RequestMapping(path="/users") // all requests starting with /pets come to this controller
@CrossOrigin(origins="http://localhost:4200") // accepts requests from angular
public class UsersController {
	@Autowired
	private UserService userServ;
	@Autowired
	private TrainerService trainServ;
	
	@PostMapping
	public ResponseEntity<Void> register(@RequestBody Users newUser) {
	if (newUser !=null) {
		try {
			userServ.register(newUser);
		} catch (UserNameAlreadyExistsException e) {
			ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
}
	
	@PostMapping(path="/auth")
	public ResponseEntity<String> logIn(@RequestBody Map<String, String> credentials) {
		String username = credentials.get("username");
		String password = credentials.get("password");
		
		try {
			Users user = userServ.logIn(username, password);
			String token = Integer.toString(user.getUserId());
			return ResponseEntity.ok(token);
		} catch (IncorrectCredentialsException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	@GetMapping(path="/{userid}/auth")
	public ResponseEntity<Users> checkLogin(@RequestBody String token, @PathVariable int userId){
		try {

			Users loggedInPerson =userServ.getUserById(userId);
			if(loggedInPerson!=null)
				return ResponseEntity.ok(loggedInPerson);
			else
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
		catch (NumberFormatException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	@GetMapping(path="/{userid}")
	public ResponseEntity<Users> getUserById(@PathVariable int userId) {
		
		
		Users user = userServ.getUserById(userId);
		if (user != null)
			return ResponseEntity.ok(user);
		else
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path="/{userId}")
	public ResponseEntity<Users> updateUser(@PathVariable int userId,
			@RequestBody Users userToEdit) {
		
		if (userToEdit != null && userToEdit.getUserId() == userId) {
			userToEdit = userServ.updateUser(userToEdit);
			if (userToEdit != null)
				return ResponseEntity.ok(userToEdit);
			else
				return ResponseEntity.notFound().build();
		} else {
			// conflict: the id doesn't match the id of the user sent
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@GetMapping
	public ResponseEntity<Set<Users>> viewAllTrainers() {

		Set<Users> availablePets = userServ.viewTrainers();
		return ResponseEntity.ok(availablePets);
	
	}
	
}

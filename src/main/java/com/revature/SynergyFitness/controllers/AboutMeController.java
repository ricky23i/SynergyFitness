package com.revature.SynergyFitness.controllers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.SynergyFitness.Beans.AboutMe;
import com.revature.SynergyFitness.services.PersonService;
import com.revature.SynergyFitness.services.TrainerService;


@RestController
@RequestMapping(path="/AboutMe")
@CrossOrigin(origins="http://localhost:4200")
public class AboutMeController {
	@Autowired
	private PersonService userServ;
	@Autowired
	private TrainerService trainServ;
	
	@GetMapping
	public ResponseEntity<List<AboutMe>> viewAllAboutMes() {
		List<AboutMe> AboutMes = userServ.viewAboutMes();
		return ResponseEntity.ok(AboutMes);
	}
			
	@GetMapping(path="/{aboutMeId}")
	public ResponseEntity<AboutMe> getAboutMeById(@PathVariable int aboutMeId) {
		AboutMe aboutMe = userServ.getAboutMeById(aboutMeId);
		
		if (aboutMe != null) {
			return ResponseEntity.ok(aboutMe);
		}
		else
			return ResponseEntity.notFound().build();
	}
	
	@PutMapping(path="/{aboutMeId}")
	public ResponseEntity<AboutMe> getAboutMeById(@PathVariable int AboutMeId, @RequestBody AboutMe AboutMeToEdit) {
		if (AboutMeToEdit != null && AboutMeToEdit.getAboutMeId() == AboutMeId) {
			AboutMeToEdit = trainServ.editAboutMe(AboutMeToEdit);
			
			if (AboutMeToEdit != null)
				return ResponseEntity.ok(AboutMeToEdit);
			else
				return ResponseEntity.notFound().build();
		} else {
			// conflict: the id doesn't match the id of the user sent
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}

package com.revature.SynergyFitness.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.revature.SynergyFitness.Beans.UserComments;
import com.revature.SynergyFitness.services.PersonService;
import com.revature.SynergyFitness.services.TrainerService;
@RestController // basically puts @ResponseBody over ALL methods - no returning views
@RequestMapping(path="/comments") // all requests starting with /pets come to this controller
@CrossOrigin(origins="http://localhost:4200") // accepts requests from angular
public class CommentController {
	@Autowired
	private PersonService userServ;
	@Autowired
	private TrainerService trainServ;
	
	@PostMapping
	public ResponseEntity<Void> addComment(@RequestBody UserComments newComment) {
		if (newComment !=null) {
			userServ.addComment(newComment);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}

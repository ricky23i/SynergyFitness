package com.revature.SynergyFitness.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	private static PersonService userServ;
	private static TrainerService trainServ;
	

	public CommentController() {super();}
	// field injection
		@Autowired
		public CommentController(PersonService userServ, TrainerService trainServ) {
			this.userServ=userServ;
			this.trainServ=trainServ;
		}
		

	
	@PostMapping
	public ResponseEntity<Void> addComment(@RequestBody UserComments newComment) {
		if (newComment !=null) {
			userServ.addComment(newComment);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PutMapping(path="/{commentId}")
	public ResponseEntity<UserComments> updateComment(@PathVariable UserComments upComment,
			@RequestBody UserComments commToEdit) {

		
		if (commToEdit != null) {
			commToEdit = userServ.editComment(commToEdit);
			if (commToEdit != null)
				return ResponseEntity.ok(commToEdit);
			else
				return ResponseEntity.notFound().build();
		} else {
			// conflict: the id doesn't match the id of the user sent
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	
	}
	
	@DeleteMapping(path="/{commentId}")
	public  ResponseEntity<Void> deleteComment(@RequestBody UserComments deleteComment) {
		
		
		if (deleteComment !=null) {
			userServ.addComment(deleteComment);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
}


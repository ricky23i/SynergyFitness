package com.revature.SynergyFitness.controllers;

import java.util.List;
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

import com.revature.SynergyFitness.Beans.Person;
import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.Beans.UserComments;
import com.revature.SynergyFitness.services.PersonService;
import com.revature.SynergyFitness.services.TrainerService;




@RestController // basically puts @ResponseBody over ALL methods - no returning views
@RequestMapping(path="/posts") // all requests starting with /pets come to this controller
@CrossOrigin(origins="http://localhost:4200/") // accepts requests from angular
public class PostController {

	// field injection
		@Autowired
		private PersonService userServ;
		@Autowired
		private TrainerService trainServ;
		
		@GetMapping
		public ResponseEntity<List<Post>> getPosts() {
			return ResponseEntity.ok(trainServ.getAllPosts());
			//return ResponseEntity.status(HttpStatus.OK).body(availablePets);
		}
		
	
		
		@PostMapping
		public ResponseEntity<Void> addPost(@RequestBody Post newPost) {
			
			
			if (newPost !=null) {
				trainServ.addPost(newPost);
				return ResponseEntity.status(HttpStatus.CREATED).build();
			}
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
		@GetMapping(path="/{postId}")
		public ResponseEntity<Post> getPostById(@PathVariable int postId) {
			
			Post post = userServ.getPostById(postId);
			if (post != null)
				return ResponseEntity.ok(post);
			else
				return ResponseEntity.notFound().build();
		}
		@PutMapping(path="/{postId}")
		public ResponseEntity<Post> updatePost(@PathVariable Post post,
				@RequestBody Post postToEdit) {

			
			if (postToEdit != null) {
				postToEdit = trainServ.editPost(postToEdit);
				if (postToEdit != null)
					return ResponseEntity.ok(postToEdit);
				else
					return ResponseEntity.notFound().build();
			} else {
				// conflict: the id doesn't match the id of the user sent
				return ResponseEntity.status(HttpStatus.CONFLICT).build();
			}
		}
		
}

package com.revature.SynergyFitness.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.SynergyFitness.Beans.CalorieTracker;
import com.revature.SynergyFitness.Beans.Person;
import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.Beans.UserComments;
import com.revature.SynergyFitness.data.CommentRepository;
import com.revature.SynergyFitness.data.PersonRepository;
import com.revature.SynergyFitness.data.PostRepository;
import com.revature.SynergyFitness.exceptions.IncorrectCredentialsException;
import com.revature.SynergyFitness.exceptions.UserNameAlreadyExistsException;


public class PersonServiceImpl implements PersonService{
	private PersonRepository personRepo;
	private CommentRepository comRepo;
	private PostRepository postRepo;
	@Autowired
	public PersonServiceImpl(PersonRepository personRepo, CommentRepository comRepo,PostRepository postRepo) {
		this.personRepo=personRepo;
		this.comRepo=comRepo;
		this.postRepo=postRepo;
	}
	
	@Override
	@Transactional
	public Person register(Person newUser) throws UserNameAlreadyExistsException {
		int newId = personRepo.save(newUser).getUserId();
		if (newId > 0) {
			newUser.setUserId(newId);
			return newUser;
		} else if (newId == -1) {
			throw new UserNameAlreadyExistsException();
		}
		return null;
	}

	@Override
	public Person logIn(String username, String password) throws IncorrectCredentialsException {
		Person personFromDatabase = personRepo.findByUsername(username);
		if (personFromDatabase != null && personFromDatabase.getPassword().equals(password)) {
			return personFromDatabase;
		} else {
			throw new IncorrectCredentialsException();
		}
	}

	@Override
	public Person getUserById(int UserId) {
		return personRepo.findById(UserId).get();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED)
	public Person updateUser(Person userToUpdate) {
		if (personRepo.existsById(userToUpdate.getUserId())) {
			personRepo.save(userToUpdate);
			userToUpdate = personRepo.findById(userToUpdate.getUserId()).get();
			return userToUpdate;
		}
		return null;
	}

	@Override
	public int getStreak(int UserId) {
		
		return personRepo.getById(UserId).getSignInCounter();
	}

	@Override
	public Set<Person> viewTrainers() {
	return personRepo.findByRoleName("trainer");
	}



	@Override
	public Set<Post> getPostByTrainer(String gymUsername) {
		return postRepo.getPostByTrainer(gymUsername);
	}

	@Override
	public Post getPostById(int Postid) {
		return postRepo.getById(Postid);
	}

	@Override
	public Person inputCalories(int userId, int Calories, String foodList) {
		return personRepo.inputCalories(userId, Calories, foodList);
	}

	@Override
	public CalorieTracker getCalories(int userId) {
		return personRepo.getCalories(userId);
	}

	@Override
	public int addComment(UserComments newComment) {
		return comRepo.save(newComment).getUser_comment_id();
	}

	@Override
	public UserComments editComment(UserComments upComment) {
	
		return comRepo.findById(upComment.getUser_comment_id()).get();
	}

	@Override
	public void deleteComment(UserComments commentToDelete) {
		UserComments commentFromDatabase = comRepo.findById(commentToDelete.getUser_comment_id()).get();
		if (commentFromDatabase !=null) {
			comRepo.delete(commentFromDatabase);
		}
		
	}

}

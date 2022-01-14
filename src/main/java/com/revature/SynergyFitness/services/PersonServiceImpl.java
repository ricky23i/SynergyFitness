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
	public Person getStreak(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Person> viewTrainers() {
	return personRepo.findByRoleName("trainer");
	}



	@Override
	public Set<Post> getPostByTrainer(String gymUsername) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(int Postid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person inputCalories(int userId, int Calories, String foodList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalorieTracker getCalories(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserComments addComment(UserComments newComment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserComments editComment(UserComments upComment) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(UserComments commentToDelete) {
		// TODO Auto-generated method stub
		
	}

}

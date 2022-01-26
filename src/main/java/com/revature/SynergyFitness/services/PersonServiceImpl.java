package com.revature.SynergyFitness.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.SynergyFitness.Beans.AboutMe;
import com.revature.SynergyFitness.Beans.CalorieTracker;
import com.revature.SynergyFitness.Beans.Person;
import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.Beans.UserComments;
import com.revature.SynergyFitness.data.AboutMeRepository;
import com.revature.SynergyFitness.data.CommentRepository;
import com.revature.SynergyFitness.data.PersonRepository;
import com.revature.SynergyFitness.data.PostRepository;
import com.revature.SynergyFitness.exceptions.IncorrectCredentialsException;
import com.revature.SynergyFitness.exceptions.UserNameAlreadyExistsException;

@Service
public class PersonServiceImpl implements PersonService{
	

	private PersonRepository personRepo;
	private CommentRepository comRepo;
	private PostRepository postRepo;
	private AboutMeRepository meRepo;
	@Autowired
	public PersonServiceImpl(PersonRepository personRepo, CommentRepository comRepo,PostRepository postRepo) {
		this.personRepo=personRepo;
		this.comRepo=comRepo;
		this.postRepo=postRepo;
	}
	@Override
	@Transactional
	public AboutMe getAboutMeById(int aboutMeId) {
		
		return meRepo.getById(aboutMeId);
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
	@Transactional
	public Person logIn(String username, String password) throws IncorrectCredentialsException {
		Person personFromDatabase = personRepo.findBygymUsername(username);
		if (personFromDatabase != null && personFromDatabase.getPassword().equals(password)) {
			return personFromDatabase;
		} else {
			throw new IncorrectCredentialsException();
		}
	}

	@Override
	@Transactional
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
	@Transactional
	public int getStreak(int UserId) {
		
		return personRepo.getById(UserId).getSignInCounter();
	}

	@Override
	@Transactional
	public Set<Person> viewTrainers() {
	return personRepo.findByRole("trainer");
	}

	@Override
	@Transactional
	public Set<Post> getPostByTrainer(String gymUsername) {
		return postRepo.findByUserGymUsername(gymUsername);
	}

	@Override
	@Transactional
	public Post getPostById(int Postid) {
		return postRepo.getById(Postid);
	}

	@Override
	@Transactional
	public Person inputCalories(int userId, int Calories, String foodList) {
	
		if(personRepo.existsById(userId)) {
		Person input= personRepo.getById(userId);
		input.getCalorieTracker().setTotalCalories(Calories);
		input.getCalorieTracker().setFoodList(foodList);
		personRepo.save(input);
		return input;
		}
		return null;
	}

	@Override
	@Transactional
	public CalorieTracker getCalories(int userId) {
		return personRepo.getById(userId).getCalorieTracker();
	}

	@Override
	@Transactional
	public int addComment(UserComments newComment) {
		return comRepo.save(newComment).getUser_comment_id();
	}

	@Override
	@Transactional
	public UserComments editComment(UserComments upComment) {
	
		return comRepo.findById(upComment.getUser_comment_id()).get();
	}

	@Override
	@Transactional
	public void deleteComment(UserComments commentToDelete) {
		UserComments commentFromDatabase = comRepo.findById(commentToDelete.getUser_comment_id()).get();
		if (commentFromDatabase !=null) {
			comRepo.delete(commentFromDatabase);
		}
		
	}
	@Override
	@Transactional
	public List<AboutMe> viewAboutMes() {
		return meRepo.findAll();
	}

}

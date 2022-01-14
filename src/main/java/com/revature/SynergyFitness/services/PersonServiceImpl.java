package com.revature.SynergyFitness.services;

import java.util.Set;

import com.revature.SynergyFitness.Beans.CalorieTracker;
import com.revature.SynergyFitness.Beans.Person;
import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.Beans.UserComments;
import com.revature.SynergyFitness.exceptions.IncorrectCredentialsException;
import com.revature.SynergyFitness.exceptions.UserNameAlreadyExistsException;

public class PersonServiceImpl implements PersonService{

	@Override
	public Person register(Person newUser) throws UserNameAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person logIn(String username, String password) throws IncorrectCredentialsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getUserById(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person updateUser(Person userToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Person getStreak(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Person> viewTrainers() {
		// TODO Auto-generated method stub
		return null;
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

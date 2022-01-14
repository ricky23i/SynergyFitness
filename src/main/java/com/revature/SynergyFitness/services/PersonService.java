package com.revature.SynergyFitness.services;

import java.util.Set;

import com.revature.SynergyFitness.Beans.CalorieTracker;
import com.revature.SynergyFitness.Beans.Person;
import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.Beans.UserComments;
import com.revature.SynergyFitness.exceptions.IncorrectCredentialsException;
import com.revature.SynergyFitness.exceptions.UserNameAlreadyExistsException;

public interface PersonService {
	public Person register(Person newUser) throws UserNameAlreadyExistsException;
	public Person logIn(String username, String password) throws IncorrectCredentialsException;
	public Person getUserById(int UserId);
	public Person updateUser(Person userToUpdate);
	public Person getStreak(int UserId);
	public Set<Person> viewTrainers();
	public Set<Post> getPostByTrainer(String gymUsername);
	public int addComment(UserComments newComment);
	public UserComments editComment(UserComments upComment);
	public void deleteComment(UserComments commentToDelete);
	public Post getPostById(int Postid);
	public Person inputCalories(int userId, int Calories,String foodList);
	public CalorieTracker getCalories(int userId);
}

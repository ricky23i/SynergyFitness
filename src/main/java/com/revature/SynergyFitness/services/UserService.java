package com.revature.SynergyFitness.services;

import java.util.Set;

import com.revature.SynergyFitness.Beans.CalorieTracker;
import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.Beans.UserComments;
import com.revature.SynergyFitness.Beans.Users;
import com.revature.SynergyFitness.exceptions.IncorrectCredentialsException;
import com.revature.SynergyFitness.exceptions.UserNameAlreadyExistsException;

public interface UserService {
	public Users register(Users newUser) throws UserNameAlreadyExistsException;
	public Users logIn(String username, String password) throws IncorrectCredentialsException;
	public Users getUserById(int UserId);
	public Users updateUser(Users userToUpdate);
	//public Users getStreak(int UserId);
	public Set<Users> viewTrainers();
	public int addComment(UserComments newComment);
	public int deleteComment(UserComments commentToDelete);
	public Set<Post> getPostByTrainer(int userId);
	public Post getPostById(int Postid);
	public Users inputCalories(int userId, int Calories,String foodList);
	public CalorieTracker getCalories(int userId);
}

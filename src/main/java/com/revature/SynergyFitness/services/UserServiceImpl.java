package com.revature.SynergyFitness.services;

import java.util.Set;

import com.revature.SynergyFitness.Beans.CalorieTracker;
import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.Beans.UserComments;
import com.revature.SynergyFitness.Beans.Users;
import com.revature.SynergyFitness.exceptions.IncorrectCredentialsException;
import com.revature.SynergyFitness.exceptions.UserNameAlreadyExistsException;

public class UserServiceImpl implements UserService{

	@Override
	public Users register(Users newUser) throws UserNameAlreadyExistsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users logIn(String username, String password) throws IncorrectCredentialsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getUserById(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users updateUser(Users userToUpdate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users getStreak(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Users> viewTrainers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addComment(UserComments newComment) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteComment(UserComments commentToDelete) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Set<Post> getPostByTrainer(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPostById(int Postid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users inputCalories(int userId, int Calories, String foodList) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CalorieTracker getCalories(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}

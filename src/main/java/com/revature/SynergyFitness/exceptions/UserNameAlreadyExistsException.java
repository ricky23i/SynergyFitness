package com.revature.SynergyFitness.exceptions;
public class UserNameAlreadyExistsException  extends Exception {
	private static final long serialVersionUID = 1712843686624302051L;
  
	public UserNameAlreadyExistsException() {
		super("The chosen username is taken by another user.");
	}
}

package com.revature.SynergyFitness.exceptions;

public class IncorrectCredentialsException extends Exception {
	private static final long serialVersionUID = -6511566985029314986L;

	public IncorrectCredentialsException() {
		super("Username or password was incorrect.");
	}
}
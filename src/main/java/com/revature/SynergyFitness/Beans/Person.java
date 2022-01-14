package com.revature.SynergyFitness.Beans;

import java.util.Objects;

public class Person {
	private int userId;
	private int roleId;
	private String trainer;
	private String gymUsername;
	private String password;
	private String firstname;
	private String lastname;
	private String lastSignInDate;
	
	public Person () {
		userId = 0;
		roleId = 0;
		trainer = " ";
		gymUsername = " ";
		password = " ";
		firstname = " ";
		lastname = " ";
		lastSignInDate = " ";
		
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public String getGymUsername() {
		return gymUsername;
	}

	public void setGymUsername(String gymUsername) {
		this.gymUsername = gymUsername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getLastSignInDate() {
		return lastSignInDate;
	}

	public void setLastSignInDate(String lastSignInDate) {
		this.lastSignInDate = lastSignInDate;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", roleId=" + roleId + ", trainer=" + trainer + ", gymUsername="
				+ gymUsername + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", lastSignInDate=" + lastSignInDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstname, gymUsername, lastSignInDate, lastname, password, roleId, trainer, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(firstname, other.firstname) && Objects.equals(gymUsername, other.gymUsername)
				&& Objects.equals(lastSignInDate, other.lastSignInDate) && Objects.equals(lastname, other.lastname)
				&& Objects.equals(password, other.password) && roleId == other.roleId
				&& Objects.equals(trainer, other.trainer) && userId == other.userId;
	}

}

package com.revature.SynergyFitness.Beans;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private Role role;
	
	private String gymUsername;
	
	@Column(name="passwd")
	private String password;
	
	private String firstname;
	
	@OneToOne
	@JoinColumn(name="tracker_id")
	private CalorieTracker calorieTracker;
	
	private String lastname;
	
	private String lastSignInDate;
	
	private int signInCounter;
	@OneToOne
	@JoinColumn(name="user_id")
	@JsonIgnoreProperties
	private Person trainer;
	
	public Person () {
		id = 0;
		role = new Role();
		trainer = null;
		gymUsername = " ";
		password = " ";
		firstname = " ";
		lastname = " ";
		lastSignInDate = " ";
		signInCounter=0;
		calorieTracker=new CalorieTracker();
		
	}



	public CalorieTracker getCalorieTracker() {
		return calorieTracker;
	}



	public void setCalorieTracker(CalorieTracker calorieTracker) {
		this.calorieTracker = calorieTracker;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getSignInCounter() {
		return signInCounter;
	}



	public void setSignInCounter(int signInCounter) {
		this.signInCounter = signInCounter;
	}



	public void setRole(Role role) {
		this.role = role;
	}



	public int getUserId() {
		return id;
	}

	public void setUserId(int userId) {
		this.id = userId;
	}

	public Role getRole() {
		return role;
	}

	public void setRoleId(Role roleId) {
		this.role = roleId;
	}

	public Person getTrainer() {
		return trainer;
	}

	public void setTrainer(Person trainer) {
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
		return "Users [userId=" + id + ", roleId=" + role + ", trainer=" + trainer + ", gymUsername="
				+ gymUsername + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", lastSignInDate=" + lastSignInDate + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return  id == other.id;
	}

}

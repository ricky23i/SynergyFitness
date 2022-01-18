package com.revature.SynergyFitness.Beans;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class CalorieTracker {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int trackerId;
    @OneToOne
    @JoinColumn(name="user_id")
    private Person user;
	private int totalCalories;
	private String foodList;
	
	public CalorieTracker() {
		trackerId = 0;
		user=null;
		totalCalories = 0;
		foodList = "";
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public int getTrackerId() {
		return trackerId;
	}

	public void setTrackerId(int trackerId) {
		this.trackerId = trackerId;
	}

	

	public int getTotalCalories() {
		return totalCalories;
	}

	public void setTotalCalories(int totalCalories) {
		this.totalCalories = totalCalories;
	}

	public String getFoodList() {
		return foodList;
	}

	public void setFoodList(String foodList) {
		this.foodList = foodList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(foodList, totalCalories, trackerId, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CalorieTracker other = (CalorieTracker) obj;
		return Objects.equals(foodList, other.foodList) && totalCalories == other.totalCalories
				&& trackerId == other.trackerId && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "CalorieTracker [trackerId=" + trackerId + ", user=" + user + ", totalCalories=" + totalCalories
				+ ", foodList=" + foodList + "]";
	}
	
	
}

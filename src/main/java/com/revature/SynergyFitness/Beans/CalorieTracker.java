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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
	private int trackerId;
	private int totalCalories;
	private String foodList;
	
	public CalorieTracker() {
		trackerId = 0;
		totalCalories = 0;
		foodList = "";
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
		return Objects.hash(foodList, totalCalories, trackerId);
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
				&& trackerId == other.trackerId;
	}

	@Override
	public String toString() {
		return "CalorieTracker [trackerId=" + trackerId + ", totalCalories=" + totalCalories + ", foodList=" + foodList
				+ "]";
	}

	
	
}

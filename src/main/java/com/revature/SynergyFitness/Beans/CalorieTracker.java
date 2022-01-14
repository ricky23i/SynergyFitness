package com.revature.SynergyFitness.Beans;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CalorieTracker {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
	private int tracker_id;
    
	private int total_calories;
	private String food_list;
	
	public CalorieTracker() {
		tracker_id = 0;
		total_calories = 0;
		food_list = "";
	}
	
	public int getTracker_id() {
		return tracker_id;
	}
	public void setTracker_id(int tracker_id) {
		this.tracker_id = tracker_id;
	}
	public int getTotal_calories() {
		return total_calories;
	}
	public void setTotal_calories(int total_calories) {
		this.total_calories = total_calories;
	}
	public String getFood_list() {
		return food_list;
	}
	public void setFood_list(String food_list) {
		this.food_list = food_list;
	}
	@Override
	public int hashCode() {
		return Objects.hash(food_list, total_calories, tracker_id);
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
		return Objects.equals(food_list, other.food_list) && total_calories == other.total_calories
				&& tracker_id == other.tracker_id;
	}
	
	
	
}

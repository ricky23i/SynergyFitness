package com.revature.SynergyFitness.data;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.SynergyFitness.Beans.CalorieTracker;
import com.revature.SynergyFitness.Beans.Person;

@Repository
public interface PersonRepository extends JpaRepository <Person, Integer>{
	
	public Person findByUsername(String username);
	public Set<Person> findByRoleName(String roleName);
	public CalorieTracker getCalories(int userId);
	public Person inputCalories(int userId, int calories, String foodList);
}

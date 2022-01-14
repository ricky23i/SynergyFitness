package com.revature.SynergyFitness.data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.SynergyFitness.Beans.Person;
@Repository
public interface PersonRepository extends JpaRepository <Person, Integer>{

	public Person findByUsername(String username);
}

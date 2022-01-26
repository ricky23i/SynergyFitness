package com.revature.SynergyFitness.data;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.SynergyFitness.Beans.AboutMe;
import com.revature.SynergyFitness.Beans.Person;

@Repository
public interface AboutMeRepository extends JpaRepository <AboutMe, Integer>{
	
	public Set<AboutMe> getAboutMes();

}

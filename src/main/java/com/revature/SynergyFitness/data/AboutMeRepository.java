package com.revature.SynergyFitness.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.SynergyFitness.Beans.AboutMe;

@Repository
public interface AboutMeRepository extends JpaRepository <AboutMe, Integer>{

}

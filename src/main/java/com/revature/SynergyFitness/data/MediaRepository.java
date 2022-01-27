package com.revature.SynergyFitness.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.SynergyFitness.Beans.Media;

@Repository
public interface MediaRepository extends JpaRepository<Media, Integer>{
}

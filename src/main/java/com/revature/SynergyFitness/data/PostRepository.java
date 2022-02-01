package com.revature.SynergyFitness.data;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.revature.SynergyFitness.Beans.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	public Set<Post> findByUserGymUsername(String gymUsername);

}

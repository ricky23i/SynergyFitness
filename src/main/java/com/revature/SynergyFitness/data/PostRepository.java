package com.revature.SynergyFitness.data;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.SynergyFitness.Beans.Post;

public interface PostRepository extends JpaRepository<Post, Integer> {
	public Set<Post> getPostByTrainer (String gymUsername);

}

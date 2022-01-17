package com.revature.SynergyFitness.services;

import org.springframework.stereotype.Service;

import com.revature.SynergyFitness.Beans.Media;
import com.revature.SynergyFitness.Beans.Post;
@Service
public interface TrainerService {
	public int addPost(Post newPost);
	public Post editPost(Post postToEdit);
	public void deletePost(Post postToDelete);
	public int addVideo(Media mediaToAdd);
	public Media editVideo(Media mediaToEdit);
	public void deleteVideo(Media mediaToRemove);
}

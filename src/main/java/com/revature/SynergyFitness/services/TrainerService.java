package com.revature.SynergyFitness.services;

import com.revature.SynergyFitness.Beans.Media;
import com.revature.SynergyFitness.Beans.Post;

public interface TrainerService {
	public int addPost(Post newPost);
	public Post editPost(Post postToEdit);
	public Post deletePost(Post postToDelete);
	public Media addVideo(Media mediaToAdd);
	public Media editVideo(Media mediaToEdit);
	public Media deleteVideo(Media mediaToRemove);
}

package com.revature.SynergyFitness.services;

import com.revature.SynergyFitness.Beans.Post;

public interface TrainerService {
	public int addPost(Post newPost);
	public Post editPost(Post postToEdit);
	public Post deletePost(Post postToDelete);
	public Post addVideo(Post mediaToAdd);
	public Post deleteVideo(Post mediaToRemove);
}

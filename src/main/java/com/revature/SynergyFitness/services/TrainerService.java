package com.revature.SynergyFitness.services;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.SynergyFitness.Beans.AboutMe;
import com.revature.SynergyFitness.Beans.Media;
import com.revature.SynergyFitness.Beans.Post;
@Service
public interface TrainerService {
	public List<Post> getAllPosts();
	public int addPost(Post newPost);
	public Post editPost(Post postToEdit);
	public void deletePost(Post postToDelete);
	public int addVideo(Media mediaToAdd);
	public Media editVideo(Media mediaToEdit);
	public void deleteVideo(Media mediaToRemove);
	public int addAboutMe(AboutMe me);
	public AboutMe editAboutMe(AboutMe upme);
}

package com.revature.SynergyFitness.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.data.PersonRepository;
import com.revature.SynergyFitness.data.PostRepository;

@Service
public class TrainerServiceImpl implements TrainerService{
	private PersonRepository personRepo;
	private PostRepository postRepo;
	
	@Autowired
	public TrainerServiceImpl(PersonRepository personRepo, PostRepository postRepo) {
		this.personRepo = personRepo;
		this.postRepo = postRepo;
	}
	@Override
	@Transactional
	public int addPost(Post newPost) {
		return postRepo.save(newPost).getPostId();
	}

	@Override
	@Transactional
	public Post editPost(Post postToEdit) {
		Post postFromDatabase = postRepo.findById(postToEdit.getPostId()).get();
		if (postFromDatabase !=null) {
			postRepo.save(postToEdit);
			return postRepo.findById(postToEdit.getPostId()).get();		}
		return null;
	}

	@Override
	@Transactional
	public Post deletePost(Post postToDelete) {
		Post postFromDatabase = postRepo.findById(postToDelete.getPostId()).get();
		if (postFromDatabase !=null) {
		return postRepo.delete(postToDelete).getPostId();
	}

	@Override
	@Transactional
	public Post addVideo(Post mediaToAdd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Post deleteVideo(Post mediaToRemove) {
		// TODO Auto-generated method stub
		return null;
	}

}

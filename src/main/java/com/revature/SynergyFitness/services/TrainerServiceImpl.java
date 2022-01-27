package com.revature.SynergyFitness.services;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.SynergyFitness.Beans.AboutMe;
import com.revature.SynergyFitness.Beans.Media;
import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.data.AboutMeRepository;
import com.revature.SynergyFitness.data.MediaRepository;
import com.revature.SynergyFitness.data.PersonRepository;
import com.revature.SynergyFitness.data.PostRepository;

@Service
public class TrainerServiceImpl implements TrainerService{
	private PersonRepository personRepo;
	private PostRepository postRepo;
	private MediaRepository mediaRepo;
	private AboutMeRepository meRepo;
	
	@Override
	@Transactional
	public int addAboutMe(AboutMe me) {
		
		return meRepo.save(me).getAboutMeId();
	}
	@Override
	@Transactional
	public AboutMe editAboutMe(AboutMe upme) {
		AboutMe aboutMeFromDatabase = meRepo.findById(upme.getAboutMeId()).get();
		if (aboutMeFromDatabase !=null) {
			meRepo.save(upme);
			return meRepo.findById(upme.getAboutMeId()).get();		
		}
		return null;
	}
	@Autowired
	public TrainerServiceImpl(PersonRepository personRepo, PostRepository postRepo, MediaRepository mediaRepo) {
		this.personRepo = personRepo;
		this.postRepo = postRepo;
		this.mediaRepo = mediaRepo;
	}
	@Override
	@Transactional
	public Post addPost(Post newPost) {
		return postRepo.save(newPost);
	}

	@Override
	@Transactional
	public Post editPost(Post postToEdit) {
		Post postFromDatabase = postRepo.findById(postToEdit.getPostId()).get();
		if (postFromDatabase !=null) {
			postRepo.save(postToEdit);
			return postRepo.findById(postToEdit.getPostId()).get();		
		}
		return null;
	}

	@Override
	@Transactional
	public List<Post> getAllPosts() {
		List<Post> posts = postRepo.findAll();
		return posts;
	}
	@Override
	@Transactional
	public void deletePost(Post postToDelete) {
		Post postFromDatabase = postRepo.findById(postToDelete.getPostId()).get();
		if (postFromDatabase !=null) {
		postRepo.delete(postFromDatabase);
		}
	}
	
	@Override
	@Transactional
	public int addVideo(Media MediaToAdd) {
		return mediaRepo.save(MediaToAdd).getMediaId();
	}
		
	@Override
	@Transactional
	public Media editVideo(Media mediaToEdit) {
		Media mediaFromDatabase = mediaRepo.findById(mediaToEdit.getMediaId()).get();
		if (mediaFromDatabase !=null) {
			mediaRepo.save(mediaToEdit);
			return mediaRepo.findById(mediaToEdit.getMediaId()).get();		
		}
		return null;
	}

	@Override
	@Transactional
	public void deleteVideo(Media mediaToRemove) {
		Media mediaFromDatabase = mediaRepo.findById(mediaToRemove.getMediaId()).get();
		if (mediaFromDatabase !=null) {
			mediaRepo.delete(mediaToRemove);
		}
	}
}

package com.revature.SynergyFitness.services;

import java.util.List;
import java.util.Set;
import java.util.Optional;

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
	
	@Autowired
	public TrainerServiceImpl(PersonRepository personRepo, PostRepository postRepo, MediaRepository mediaRepo, AboutMeRepository meRepo) {
		this.personRepo = personRepo;
		this.postRepo = postRepo;
		this.mediaRepo = mediaRepo;
		this.meRepo = meRepo;
	}
	
	@Override
	@Transactional
	public int addAboutMe(AboutMe newAboutMe) {
		AboutMe AboutMeAdded = meRepo.save(newAboutMe);
		if (AboutMeAdded != null) return AboutMeAdded.getAboutMeId();
		else return 0;
	}
	@Override
	@Transactional
	public AboutMe editAboutMe(AboutMe aboutMeToEdit) {
		Optional<AboutMe> AboutMeFromDatabase = meRepo.findById(aboutMeToEdit.getAboutMeId());
		if (AboutMeFromDatabase.isPresent()) {
			meRepo.save(aboutMeToEdit);
			return meRepo.findById(aboutMeToEdit.getAboutMeId()).get();
		}
		return null;

	}
	
	@Override
	@Transactional
	public int addPost(Post newPost) {
		return postRepo.save(newPost).getPostId();
	}

	@Override
	@Transactional
	public Post editPost(Post postToEdit) {
		Optional<Post> PostFromDatabase = postRepo.findById(postToEdit.getPostId());
		if (PostFromDatabase.isPresent()) {
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

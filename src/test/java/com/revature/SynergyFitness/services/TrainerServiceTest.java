package com.revature.SynergyFitness.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.SynergyFitness.Beans.Person;
import com.revature.SynergyFitness.Beans.AboutMe;
import com.revature.SynergyFitness.Beans.CalorieTracker;
import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.Beans.Role;
import com.revature.SynergyFitness.Beans.UserComments;
import com.revature.SynergyFitness.data.PersonRepository;
import com.revature.SynergyFitness.data.AboutMeRepository;
import com.revature.SynergyFitness.data.CommentRepository;
import com.revature.SynergyFitness.data.PostRepository;
import com.revature.SynergyFitness.exceptions.IncorrectCredentialsException;
import com.revature.SynergyFitness.exceptions.UserNameAlreadyExistsException;
import com.revature.SynergyFitness.SynergyFitnessApplication;

@SpringBootTest(classes=SynergyFitnessApplication.class)
public class TrainerServiceTest {
	@MockBean
	private PersonRepository personRepo;
	@MockBean
	private PostRepository postRepo;
	@MockBean
	private AboutMeRepository aboutMeRepo;
	@Autowired
	private TrainerService trainServ;

	@Test
	public void getAllPosts() {
		
	}
	
	@Test
	public void addPostSuccessfully() {
		Post newPost = new Post();
		Post mockPost = new Post();
		mockPost.setPostId(10);
				
		when(postRepo.save(newPost)).thenReturn(mockPost);
		
		int newId = trainServ.addPost(newPost);
		
		assertNotEquals(0, newId);
	}
	
	@Test
	public void addPostSomethingWrong() {
		Post post = new Post();
		
		when(postRepo.save(post)).thenReturn(post);
		
		int newId = trainServ.addPost(post);
		
		assertEquals(0,newId);
	}
	
	@Test
	public void editPostExists() {
		Post editedPost = new Post();
		editedPost.setPostId(2);
		editedPost.setpostData("squid");
		
		when(postRepo.findById(2)).thenReturn(Optional.of(editedPost));
		when(postRepo.save(Mockito.any(Post.class))).thenReturn(editedPost);
		
		Post actualPost = trainServ.editPost(editedPost);
		
		assertEquals(editedPost, actualPost);
	}
	
	@Test
	public void editPostDoesNotExist() {
		when(postRepo.findById(2)).thenReturn(Optional.empty());
		
		Post editedPost = new Post();
		editedPost.setPostId(2);
		editedPost.setpostData("squid");
		
		Post actualPost = trainServ.editPost(editedPost);
		
		assertNull(actualPost);
		verify(postRepo, times(0)).save(Mockito.any(Post.class));
	}
	
	@Test
	public void addAboutMeSuccessfully() {
		AboutMe newAboutMe = new AboutMe();
		AboutMe mockAboutMe = new AboutMe();
		mockAboutMe.setAboutMeId(10);
				
		when(aboutMeRepo.save(newAboutMe)).thenReturn(mockAboutMe);
		
		int newId = trainServ.addAboutMe(newAboutMe);
		
		assertNotEquals(0, newId);
	}
	
	@Test
	public void addAboutMeSomethingWrong() {
		AboutMe AboutMe = new AboutMe();
		
		when(aboutMeRepo.save(AboutMe)).thenReturn(AboutMe);
		
		int newId = trainServ.addAboutMe(AboutMe);
		
		assertEquals(0,newId);
	}
	
	@Test
	public void editAboutMeExists() {
		AboutMe editedAboutMe = new AboutMe();
		editedAboutMe.setAboutMeId(2);
		editedAboutMe.setTrainerAge(7);
		
		when(aboutMeRepo.findById(2)).thenReturn(Optional.of(editedAboutMe));
		when(aboutMeRepo.save(Mockito.any(AboutMe.class))).thenReturn(editedAboutMe);
		
		AboutMe actualAboutMe = trainServ.editAboutMe(editedAboutMe);
		
		assertEquals(editedAboutMe, actualAboutMe);
	}
	
	@Test
	public void editAboutMeDoesNotExist() {
		when(aboutMeRepo.findById(2)).thenReturn(Optional.empty());
		
		AboutMe editedAboutMe = new AboutMe();
		editedAboutMe.setAboutMeId(2);
		editedAboutMe.setTrainerAge(7);
		
		AboutMe actualAboutMe = trainServ.editAboutMe(editedAboutMe);
		
		assertNull(actualAboutMe);
		verify(aboutMeRepo, times(0)).save(Mockito.any(AboutMe.class));
	}

}

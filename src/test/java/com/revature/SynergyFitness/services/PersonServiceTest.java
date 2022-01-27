package com.revature.SynergyFitness.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.SynergyFitness.Beans.Person;
import com.revature.SynergyFitness.Beans.CalorieTracker;
import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.Beans.Role;
import com.revature.SynergyFitness.Beans.UserComments;
import com.revature.SynergyFitness.data.PersonRepository;
import com.revature.SynergyFitness.data.CommentRepository;
import com.revature.SynergyFitness.data.PostRepository;
import com.revature.SynergyFitness.exceptions.IncorrectCredentialsException;
import com.revature.SynergyFitness.exceptions.UserNameAlreadyExistsException;
import com.revature.SynergyFitness.SynergyFitnessApplication;

@SpringBootTest(classes=SynergyFitnessApplication.class)
public class PersonServiceTest {
	@MockBean
	private PersonRepository personRepo;
	@MockBean
	private CommentRepository commentRepo;
	@MockBean
	private PostRepository postRepo;
	@Autowired
	private PersonService personServ;
	
	private static Set<Post> mockPosts;
	
	private static Set<UserComments> mockComments;
	
	@BeforeAll
	public static void mockPostsSetUp() {
		mockPosts = new HashSet<>();
		
		for (int i=1; i<=5; i++) {
			Post post = new Post();
			post.setPostId(i);
			if (i<3)
				post.setpostData("100 Push-ups\r\n"
						+ "100 Sit-ups\r\n"
						+ "100 Squats\r\n"
						+ "10 Km run.\r\n"
						+ "\r\n"
						+ "EVERY SINGLE DAY!");
			mockPosts.add(post);
		}
	}
	
	@BeforeAll
	public static void mockCommentsSetUp() {
		mockComments = new HashSet<>();
			
		for (int i=1; i<=5; i++) {
			UserComments comment = new UserComments();
			comment.setUser_comment_id(i);
			if (i<3)
				comment.setComment_data("OK");
			mockComments.add(comment);
		}
	}
	
	@Test
	public void loginSuccsesfully() throws IncorrectCredentialsException {
		String username="qwertyuiop";
		String password="pass";
		
		// set up the mocking
		Person mockPerson = new Person();
		mockPerson.setGymUsername(username);
		mockPerson.setPassword(password);
		when(personRepo.findBygymUsername(username)).thenReturn(mockPerson);
		
		// call the method we're testing
		Person actualPerson = personServ.logIn(username, password);
		
		// assert the expected behavior/output
		assertEquals(mockPerson,actualPerson);

	}
	
	@Test
	public void logInIncorrectPassword() {
		String username="qwertyuiop";
		String password="12345";
		
		Person mockPerson = new Person();
		mockPerson.setGymUsername(username);
		mockPerson.setPassword("pass");
		when(personRepo.findBygymUsername(username)).thenReturn(mockPerson);
		
		assertThrows(IncorrectCredentialsException.class, () -> {
			personServ.logIn(username, password);
		});
	}
	
	@Test
	public void logInUsernameDoesNotExist() {
		String username="asdfghjkl";
		String password="pass";
		
		when(personRepo.findBygymUsername(username)).thenReturn(null);
		
		assertThrows(IncorrectCredentialsException.class, () -> {
			personServ.logIn(username, password);
		});
	}
	
	@Test
	public void registerPersonSuccessfully() throws UserNameAlreadyExistsException {
		Person person = new Person();
		person.setId(10);
		
		when(personRepo.save(person)).thenReturn(person);
		
		Person actualPerson = personServ.register(person);
		assertEquals(10, actualPerson.getId());
	}
	
	@Test
	public void registerPersonSomethingWrong() throws UserNameAlreadyExistsException {
		Person person = new Person();
		when(personRepo.save(person)).thenThrow(new RuntimeException());
		Person actualPerson = personServ.register(person);
		assertNull(actualPerson);
	}


}


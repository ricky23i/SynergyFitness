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
public class PersonServiceTest {
	@MockBean
	private PersonRepository personRepo;
	@MockBean
	private CommentRepository commentRepo;
	@MockBean
	private PostRepository postRepo;
	@MockBean
	private AboutMeRepository aboutMeRepo;
	@Autowired
	private PersonService personServ;
	
	private static Role role;
	
	private static Set<Person> mockTrainers;
	
	private static Set<Post> mockPosts;
	
	private static Set<UserComments> mockComments;
	
	private static Set<AboutMe> mockAboutMes;
	
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
	
	@BeforeAll
	public static void mockTrainersSetUp() {
		mockTrainers = new HashSet<>();
		role = new Role();
		role.setRoleId(2);
		role.setRoleName("trainer");
		
			
		for (int i=1; i<=5; i++) {
			Person person = new Person();
			person.setId(i);
			if (i<3)
				person.setRole(role);
			mockTrainers.add(person);
		}
	}
	
	@Test
	public void loginSuccsesfully() throws IncorrectCredentialsException {
		String username="qwertyuiop";
		String password="pass";

		Person mockPerson = new Person();
		mockPerson.setGymUsername(username);
		mockPerson.setPassword(password);
		when(personRepo.findBygymUsername(username)).thenReturn(mockPerson);

		Person actualPerson = personServ.logIn(username, password);
		
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
	
	@Test
	public void getByIdPersonExists() {
		Person person = new Person();
		person.setId(2);
		
		when(personRepo.findById(2)).thenReturn(Optional.of(person));
		
		Person actualPerson = personServ.getUserById(2);
		assertEquals(person, actualPerson);
	}
	
	@Test
	public void getByIdPersonDoesNotExist() {
		when(personRepo.findById(2)).thenReturn(Optional.empty());
		
		Person actualPerson = personServ.getUserById(2);
		assertNull(actualPerson);
	}

	
	@Test
	public void updateSuccessfully() {
		Person mockPerson = new Person();
		mockPerson.setId(1);
		
		when(personRepo.existsById(1)).thenReturn(true);
		when(personRepo.save(Mockito.any(Person.class))).thenReturn(mockPerson);
		when(personRepo.findById(1)).thenReturn(Optional.of(mockPerson));

		Person updatedPerson = personServ.updateUser(mockPerson);
		assertNotNull(updatedPerson);
	}
	
	@Test
	public void updateSomethingWrong() {
		Person mockPerson = new Person();
		mockPerson.setId(1);
		
		when(personRepo.existsById(1)).thenReturn(false);

		Person updatedPerson = personServ.updateUser(mockPerson);
		assertNull(updatedPerson);
	}
	
	@Test
	public void viewTrainers() {
		when(personRepo.findByRole("trainer")).thenReturn(mockTrainers);
		
		Set<Person> actualTrainers = personServ.viewTrainers();
		
		assertEquals(mockTrainers, actualTrainers);
	}
	
	@Test
	public void getPostByTrainerExists() {
//		Post mockPost = new Post();
//		Person mockPerson = new Person();
//		mockPost.setUser(mockPerson);
//		
//		when(postRepo.getById())
//		
//		Set<Post> actualPosts = personServ.getPostByTrainer("CDS");
//		
//		assertEquals()
	}
	
	@Test
	public void getPostByTrainerDoesNotExist() {
//		Post mockPost = new Post();
//		Person mockPerson = new Person();
//		mockPost.setUser(mockPerson);
//		
//		when(postRepo.getById())
	}
	
	@Test
	public void addCommentSuccessfully() {
		UserComments newComment = new UserComments();
		UserComments mockComment = new UserComments();
		mockComment.setUser_comment_id(10);
		
		when(commentRepo.save(newComment)).thenReturn(mockComment);
	
		int newId = personServ.addComment(newComment);
	
		assertNotEquals(0, newId);
	}
	
	@Test
	public void addCommentSomethingWrong() {
		UserComments newComment = new UserComments();
		
		when(commentRepo.save(newComment)).thenReturn(newComment);
		
		int newId = personServ.addComment(newComment);
		
		assertEquals(0,newId);
	}
	@Test
	public void editCommentSuccessfully() {
		UserComments editedComment = new UserComments();
		editedComment.setUser_comment_id(2);
		editedComment.setComment_data("Yes");
		
		when(commentRepo.findById(2)).thenReturn(Optional.of(editedComment));
		when(commentRepo.save(Mockito.any(UserComments.class))).thenReturn(editedComment);
		
		UserComments actualComment = personServ.editComment(editedComment);
		
		assertEquals(editedComment, actualComment);
	}
	
	@Test
	public void editCommentDoesNotExist() {
//		when(personRepo.findById(2)).thenReturn(Optional.empty());
//		
//		UserComments editedComment = new UserComments ();
//		editedComment.setUser_comment_id(2);
//		editedComment.setComment_data("Yes");
//		
//		UserComments actualComment = personServ.editComment(editedComment);
//		
//		assertNull(actualComment);
//		verify(personRepo, times(0)).save(Mockito.any(UserComments.class));
	}

	
	@Test
	public void getPostByIdExists() {
		Post mockPost = new Post();
		mockPost.setPostId(1);
		
		when(postRepo.findById(1)).thenReturn(Optional.of(mockPost));
		
		Post actualPost = personServ.getPostById(1);
		assertEquals(mockPost, actualPost);
	}
	
	@Test
	public void getPostByIdDoesNotExist() {
		when(postRepo.findById(1)).thenReturn(Optional.empty());
		
		Post actualPost = personServ.getPostById(1);
		assertNull(actualPost);
	}
	
	@Test
	public void addCalories() {
		
	}
	
	@Test
	public void getcalloriesExists() {
//		CalorieTracker mockCalorie = new CalorieTracker();
//		mockCalorie.setUserID(1);
//		
//		when(postRepo.findById(1)).thenReturn(Optional.of(mockCalorie));
//		
//		CalorieTracker actualCalorie = personServ.getCalories(1);
//		assertEquals(mockCalorie, actualPost);
	}
	
	@Test
	public void getAboutMyByIdExists() {
		AboutMe mockAboutMe = new AboutMe();
		mockAboutMe.setAboutMeId(1);
		
		when(aboutMeRepo.findById(1)).thenReturn(Optional.of(mockAboutMe));
		
		AboutMe actualAboutMe = personServ.getAboutMeById(1);
		assertEquals(mockAboutMe, actualAboutMe);
	}
	
	@Test
	public void getAboutMyByIDDoesNotExist() {
		when(aboutMeRepo.findById(1)).thenReturn(Optional.empty());
		
		Post actualAboutMe = personServ.getPostById(1);
		assertNull(actualAboutMe);
	}
}


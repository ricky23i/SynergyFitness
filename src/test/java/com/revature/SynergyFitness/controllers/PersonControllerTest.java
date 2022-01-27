package com.revature.SynergyFitness.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.SynergyFitness.SynergyFitnessApplication;
import com.revature.SynergyFitness.Beans.Person;
import com.revature.SynergyFitness.exceptions.IncorrectCredentialsException;
import com.revature.SynergyFitness.exceptions.UserNameAlreadyExistsException;
import com.revature.SynergyFitness.services.PersonService;

@SpringBootTest(classes=SynergyFitnessApplication.class)
public class PersonControllerTest {
	
	@MockBean
	private PersonService userServ;
	// we'll have Spring inject the users controller so we can test it
	@Autowired
	private PersonController usersCtrl;
	// this object will allow us to mock HTTP requests sent to our application
	// so that we can finally unit test our controllers (rather than just integration test)
	private static MockMvc mockMvc;
	
	private ObjectMapper objMapper = new ObjectMapper();
	
	@BeforeAll
	public static void setUp() {
		// this initializes the Spring Web/MVC architecture for just one controller
		// so that we can isolate and unit test it
		mockMvc = MockMvcBuilders.standaloneSetup(PersonController.class).build();
	}
	
	@Test
	public void checkLoginUserExists() throws Exception {
		when(userServ.getUserById(1)).thenReturn(new Person());
		
		mockMvc.perform(get("/users/{userId}/auth", 1))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andReturn();
	}
	
	@Test
	public void checkLoginUnauthorized() throws Exception {
		when(userServ.getUserById(0)).thenReturn(null);
		
		mockMvc.perform(get("/users/{userId}/auth", 0))
			.andExpect(status().isUnauthorized())
			.andReturn();
	}
	
	@Test
	public void getUserByIdUserExists() throws Exception {
		when(userServ.getUserById(1)).thenReturn(new Person());
		
		mockMvc.perform(get("/users/{userId}", 1))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andReturn();
	}
	
	@Test
	public void getUserByIdUserDoesNotExist() throws Exception {
		when(userServ.getUserById(0)).thenReturn(null);
		
		mockMvc.perform(get("/users/{userId}", 0))
			.andExpect(status().isNotFound())
			.andReturn();
	}
	
	@Test
	public void logInCorrectly() throws Exception {
		when(userServ.logIn("test", "test")).thenReturn(new Person());
		
		String jsonCredentials = "{"
				+ "\"username\":\"test\","
				+ "\"password\":\"test\""
				+ "}";
		mockMvc
			.perform(post("/users/auth").content(jsonCredentials).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().string("0"))
			.andReturn();
	}
	
	@Test
	public void logInIncorrectCredentials() throws Exception {
		Map<String, String> credentials = new HashMap<>();
		credentials.put("username", "test");
		credentials.put("password", "test");
		
		when(userServ.logIn(credentials.get("username"), credentials.get("password")))
			.thenThrow(IncorrectCredentialsException.class);
		
		String jsonCredentials = objMapper.writeValueAsString(credentials);
		
		mockMvc
			.perform(post("/users/auth").content(jsonCredentials).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isNotFound())
			.andReturn();
	}
	
	@Test
	public void registerSuccessfully() throws Exception {
		Person newUser = new Person();
		
		when(userServ.register(newUser)).thenReturn(newUser);
		Map<String,Integer> idMap = new HashMap<>();
		idMap.put("generatedId", 0);
		
		String jsonUser = objMapper.writeValueAsString(newUser);
		String jsonIdMap = objMapper.writeValueAsString(idMap);
		mockMvc.perform(post("/users").content(jsonUser).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated())
				.andExpect(content().json(jsonIdMap))
				.andReturn();
	}
	
	@Test
	public void registerUsernameAlreadyExists() throws Exception {
		Person newUser = new Person();
		
		when(userServ.register(newUser)).thenThrow(UserNameAlreadyExistsException.class);
		
		String jsonUser = objMapper.writeValueAsString(newUser);
		mockMvc.perform(post("/users").content(jsonUser).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isConflict())
				.andReturn();
	}

	
	
	
	

	
	



	


	
}

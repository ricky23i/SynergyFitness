package com.revature.SynergyFitness.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

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
import com.revature.SynergyFitness.Beans.Post;
import com.revature.SynergyFitness.services.PersonService;
import com.revature.SynergyFitness.services.TrainerService;

@SpringBootTest(classes=SynergyFitnessApplication.class)
public class PostsControllerTest {
	@MockBean
	private TrainerService trainServ;
	@MockBean
	private PersonService userServ;
	@Autowired
	private PostController postsCtrl;
	
	// this object basically represents a mock of the Spring Web architecture
	private static MockMvc mockMvc;
	
	// this is a Jackson object mapper for JSON marshalling
	// (turning objects to JSON strings and vice versa
	private ObjectMapper objMapper = new ObjectMapper();
	
	@BeforeAll
	public static void setUp() {
		// sets up the minimum architecture to test our controller
		mockMvc = MockMvcBuilders.standaloneSetup(PostController.class).build();
	}
	
	@Test
	public void getAvailablePosts() throws Exception {
		when(trainServ.getAllPosts()).thenReturn(Collections.emptyList());
		
		String jsonSet = objMapper.writeValueAsString(Collections.emptyList());
		
		mockMvc.perform(get("/posts"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON))
			.andExpect(content().json(jsonSet))
			.andReturn();
	}
	
	@Test
	public void addPostSuccessfully() throws Exception {
		Post newPost = new Post();
		Post mockPost = new Post();
		when(trainServ.addPost(newPost)).thenReturn(1);
		
		String jsonPet = objMapper.writeValueAsString(newPost);
		
		mockMvc.perform(post("/posts").content(jsonPet).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andReturn();
	}


	

}

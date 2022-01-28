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
import com.revature.SynergyFitness.Beans.Media;
import com.revature.SynergyFitness.services.MediaService;

@SpringBootTest(classes=SynergyFitnessApplication.class)
public class MediaControllerTest {

	@MockBean
	private MediaService mediaServ;
	@Autowired
	private MediaController mediaCtrl;
	
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
	public void safeInfoSuccessfully() throws Exception {
		Media newMedia = new Media();
		when(mediaServ.saveMedia(newMedia)).thenReturn(1);
		
		String jsonMedia = objMapper.writeValueAsString(newMedia);
		
		mockMvc.perform(post("/saveinfo").content(jsonMedia).contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andReturn();
	}

	


	
	
}

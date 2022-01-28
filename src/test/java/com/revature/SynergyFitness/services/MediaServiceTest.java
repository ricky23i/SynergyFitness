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


import com.revature.SynergyFitness.Beans.Media;
import com.revature.SynergyFitness.data.MediaRepository;
import com.revature.SynergyFitness.SynergyFitnessApplication;

@SpringBootTest(classes=SynergyFitnessApplication.class)
public class MediaServiceTest {
	@MockBean
	private MediaRepository mediaRepo;
	@Autowired
	private MediaService mediaServ;

	@Test
	public void saveMediaSuccessfully() {
		Media media = new Media();
		Media mockMedia = new Media();
		mockMedia.setMediaId(10);
		
		when(mediaRepo.save(media)).thenReturn(mockMedia);
		
		int newId = mediaServ.saveMedia(media);
		
		assertNotEquals(0, newId);
	}
	
	@Test
	public void saveMediaSomethingWrong() {
		Media media = new Media();
		
		when(mediaRepo.save(media)).thenReturn(media);
		
		int newId = mediaServ.saveMedia(media);
		
		assertEquals(0,newId);

	}
	
	@Test
	public void getByIDMediaExists() {
		Media media = new Media();
		media.setMediaId(2);
		
		when(mediaRepo.findById(2)).thenReturn(Optional.of(media));
		
		Media actualMedia = mediaServ.getByID(2);
		assertEquals(media, actualMedia);
	}
	
	@Test
	public void getByIDMediaDoesNotExist() {
		when(mediaRepo.findById(2)).thenReturn(Optional.empty());
		
		Media actualMedia = mediaServ.getByID(2);
		assertNull(actualMedia);
	}
}

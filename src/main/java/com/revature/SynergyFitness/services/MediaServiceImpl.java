package com.revature.SynergyFitness.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.SynergyFitness.Beans.Media;
import com.revature.SynergyFitness.data.MediaRepository;

@Service
public class MediaServiceImpl implements MediaService {
	private MediaRepository mediaRepo;
	
	@Autowired
	public MediaServiceImpl(MediaRepository mediaRepo) {
		this.mediaRepo = mediaRepo;
	}

	@Override
	@Transactional
	public int saveMedia(Media media) throws IllegalArgumentException {
		Media mediaAdded = mediaRepo.save(media);
		if (mediaAdded != null) return mediaAdded.getMediaId();
		else return 0;
	}

	@Override
	@Transactional
	public boolean deleteMedia(Media media) {
		// TODO Auto-generated method stub
		boolean isDeleted = false;
		try {
			mediaRepo.delete(media);
			isDeleted = true;
		} catch(IllegalArgumentException e) {
			isDeleted = false;
		}
		return isDeleted;
	}

	@Override
	@Transactional
	public Media getByID(int id) {
		Optional<Media> mediaFromDatabase = mediaRepo.findById(id);
		if (mediaFromDatabase.isPresent()) return mediaFromDatabase.get();
		else return null;

	}

	@Override
	@Transactional
	public List<Media> findByPost(int postId) {
		// TODO Auto-generated method stub
		List<Media> mediaList = mediaRepo.findAll();
		List<Media> newMediaList = new ArrayList<>();
		
		mediaList.forEach(media -> {
			if(media.getPost().getPostId() == postId) {
				newMediaList.add(media);
			}
		});
		
		return newMediaList;
	}
}

package com.revature.SynergyFitness.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public boolean saveMedia(Media media) {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean deleteMedia(Media media) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Media getByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String generateFilename() {
		// TODO Auto-generated method stub
		return null;
	}

}

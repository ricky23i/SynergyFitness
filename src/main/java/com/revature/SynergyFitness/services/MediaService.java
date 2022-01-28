package com.revature.SynergyFitness.services;

import org.springframework.stereotype.Service;

import com.revature.SynergyFitness.Beans.Media;

@Service
public interface MediaService {
	public int saveMedia(Media media);
	public boolean deleteMedia(Media media);
	public Media getByID(int id);
}

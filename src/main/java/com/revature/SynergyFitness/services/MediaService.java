package com.revature.SynergyFitness.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.SynergyFitness.Beans.Media;

@Service
public interface MediaService {
	public Media saveMedia(Media media);
	public boolean deleteMedia(Media media);
	public Media getByID(int id);
	public List<Media> findByPost(int postId);
}

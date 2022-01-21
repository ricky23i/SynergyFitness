package com.revature.SynergyFitness.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.SynergyFitness.services.MediaService;

@RestController
@RequestMapping(path="/media")
@CrossOrigin(origins="http://localhost:4200")
public class MediaController {
	private static MediaService mediaServ;
	private static final String MEDIA_URL = System.getProperty("user.dir") + "\\media\\";
	
	public MediaController() {
		super();
	}
	
	public MediaController(MediaService mediaServ) {
		this.mediaServ = mediaServ;
	}
	
	@PostMapping("/upload")
	public ResponseEntity<List<String>> uploadFiles(@RequestParam("files")List<MultipartFile> multipartFiles) throws IOException{
//		boolean isUploaded = false;
		List<String> filenames = new ArrayList<>();
		try {

			for(MultipartFile file : multipartFiles) {
				String filename = StringUtils.cleanPath(file.getOriginalFilename());
				Path mediaStorage = Paths.get(MEDIA_URL, filename).toAbsolutePath().normalize();
				Files.copy(file.getInputStream(), mediaStorage, StandardCopyOption.REPLACE_EXISTING);
				filenames.add(filename);
			}
//			isUploaded = true;
		} catch (IOException e) {
//			isUploaded = false;
			return ResponseEntity.internalServerError().body(filenames);
		}
		
		return ResponseEntity.ok().body(filenames);
	}
}

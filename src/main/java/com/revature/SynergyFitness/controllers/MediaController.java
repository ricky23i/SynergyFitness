package com.revature.SynergyFitness.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.SynergyFitness.Beans.Media;
import com.revature.SynergyFitness.services.MediaService;
import com.revature.SynergyFitness.services.PersonService;
import com.revature.SynergyFitness.services.TrainerService;

@RestController
@RequestMapping(path="/media")
@CrossOrigin(origins="http://localhost:4200")
public class MediaController {
	
	private static MediaService mediaServ;
	
	public MediaController() {super();}
	// field injection
		@Autowired
		public MediaController(MediaService mediaServ) {
			this.mediaServ=mediaServ;
		}

	
	private static final String MEDIA_URL = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\media";
		
	@PostMapping("/upload")
	public ResponseEntity<List<Media>> uploadFiles(@RequestParam("files")List<MultipartFile> multipartFiles) throws IOException{
//		boolean isUploaded = false;
		List<Media> mediaFiles = new ArrayList<>();
		String url = "http://localhost:8080/";
		try {
			System.out.println(multipartFiles);
			for(MultipartFile file : multipartFiles) {
				Media media = new Media();
				
				String filename = StringUtils.cleanPath(file.getOriginalFilename());
				String[] split = filename.split("\\.",2);
				String generated = this.generateFilename();
				filename = generated + "." + split[split.length-1];
				
				Path mediaStorage = Paths.get(MEDIA_URL, filename).toAbsolutePath().normalize();
				Files.copy(file.getInputStream(), mediaStorage, StandardCopyOption.REPLACE_EXISTING);
				
				media.setFileName(filename);
				media.setMediaUrl(url + filename);
//				media = mediaServ.saveMedia(media);
				
				mediaFiles.add(media);
			}
//			isUploaded = true;
		} catch (IOException e) {
//			isUploaded = false;
			return ResponseEntity.internalServerError().body(mediaFiles);
		}
		
		return ResponseEntity.ok().body(mediaFiles);
	}
	
	@PostMapping(path="/saveinfo")
	public ResponseEntity<Void> safeInfo(@RequestBody Media media) {
		try {
			if(media != null) {
				mediaServ.saveMedia(media);
				return ResponseEntity.status(HttpStatus.CREATED).build();
			}
		} catch(IllegalArgumentException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	

	private String generateFilename() {
		// TODO Auto-generated method stub
		String[] numbers = {"1","2","3","4","5","6","7","8","9","0","A","B","C","D","E","F"};
		String filename = "";
		
		for(int i=0;i<16;i++) {
			Random random = new Random();
			filename = filename + numbers[random.nextInt(16)];
		}
		
		return filename;
	}
}

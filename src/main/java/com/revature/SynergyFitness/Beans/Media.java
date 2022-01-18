package com.revature.SynergyFitness.Beans;


import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.JoinColumn;
@Entity
public class Media {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mediaId;
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;
	private String mediaUrl;
	private String fileName;
	
	public Media() {
		mediaId=0;
		post= new Post();
		mediaUrl="";
		fileName="";
		
		
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fileName, mediaId, mediaUrl, post);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Media other = (Media) obj;
		return Objects.equals(fileName, other.fileName) && mediaId == other.mediaId
				&& Objects.equals(mediaUrl, other.mediaUrl) && Objects.equals(post, other.post);
	}

	@Override
	public String toString() {
		return "Media [mediaId=" + mediaId + ", post=" + post + ", mediaUrl=" + mediaUrl + ", fileName=" + fileName
				+ "]";
	}
	

	
}

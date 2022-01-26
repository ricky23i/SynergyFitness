package com.revature.SynergyFitness.Beans;


import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
@Entity
public class Media {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="media_id")
	private int mediaId;
	
	@Transient
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;
	
	@Column(name="media_url")
	private String mediaUrl;
	
	@Column(name="file_name")
	private String fileName;
	
	public Media() {
		mediaId=0;
		post= new Post();
		mediaUrl="";
		fileName="";
	}

	public Media(int mediaId, Post post, String mediaUrl, String fileName) {
		super();
		this.mediaId = mediaId;
		this.post = post;
		this.mediaUrl = mediaUrl;
		this.fileName = fileName;
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
		return this.mediaId == other.mediaId;
	}

	@Override
	public String toString() {
		return "Media [mediaId=" + mediaId + ", post=" + post + ", mediaUrl=" + mediaUrl + ", fileName=" + fileName
				+ "]";
	}
	

	
}

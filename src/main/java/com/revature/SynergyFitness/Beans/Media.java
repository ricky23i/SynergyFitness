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
	private String mediaPath;
	
	public Media() {
		mediaId=0;
		post= new Post();
		mediaPath="";
		
		
	}
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	public int getMediaId() {
		return mediaId;
	}
	
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}

	public String getMediaPath() {
		return mediaPath;
	}

	public void setMediaPath(String mediaPath) {
		this.mediaPath = mediaPath;
	}

	@Override
	public int hashCode() {
		return Objects.hash(mediaId, mediaPath, post);
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
		return mediaId == other.mediaId && Objects.equals(mediaPath, other.mediaPath)
				&& Objects.equals(post, other.post);
	}

	@Override
	public String toString() {
		return "Media [mediaId=" + mediaId + ", post=" + post + ", mediaPath=" + mediaPath + "]";
	}
	

	

	
}

package com.revature.SynergyFitness.Beans;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
@Entity
@Table(name="media")
public class Media {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int mediaId;
	@ManyToOne
	@JoinColumn(name="post_id")
	private Post post;
	private String media_path;
	
	public Media() {
		mediaId=0;
		post= new Post();
		media_path="";
		
		
	}
	
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	/**
	 * @return the media_int
	 */
	public int getMediaId() {
		return mediaId;
	}
	/**
	 * @param media_int the media_int to set
	 */
	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
	}
	
	/**
	 * @return the media_path
	 */
	public String getMedia_path() {
		return media_path;
	}
	/**
	 * @param media_path the media_path to set
	 */
	public void setMedia_path(String media_path) {
		this.media_path = media_path;
	}


	
}

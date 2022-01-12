package com.revature.SynergyFitness.Beans;

import java.util.Objects;

public class Media {
	private int media_int;
	private int post_id;
	private String media_path;
	
	
	/**
	 * @return the media_int
	 */
	public int getMedia_int() {
		return media_int;
	}
	/**
	 * @param media_int the media_int to set
	 */
	public void setMedia_int(int media_int) {
		this.media_int = media_int;
	}
	/**
	 * @return the post_id
	 */
	public int getPost_id() {
		return post_id;
	}
	/**
	 * @param post_id the post_id to set
	 */
	public void setPost_id(int post_id) {
		this.post_id = post_id;
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
	@Override
	public int hashCode() {
		return Objects.hash(media_int, media_path, post_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Media)) {
			return false;
		}
		Media other = (Media) obj;
		return media_int == other.media_int && Objects.equals(media_path, other.media_path) && post_id == other.post_id;
	}
	
}

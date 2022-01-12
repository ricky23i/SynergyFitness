package com.revature.SynergyFitness.Beans;

import java.util.Objects;

public class UserComments {
	private int user_comment_id;
	private int user_id;
	private int reply_id;
	private String comment_data;
	
	
	/**
	 * @return the user_comment_id
	 */
	public int getUser_comment_id() {
		return user_comment_id;
	}
	/**
	 * @param user_comment_id the user_comment_id to set
	 */
	public void setUser_comment_id(int user_comment_id) {
		this.user_comment_id = user_comment_id;
	}
	/**
	 * @return the user_id
	 */
	public int getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the reply_id
	 */
	public int getReply_id() {
		return reply_id;
	}
	/**
	 * @param reply_id the reply_id to set
	 */
	public void setReply_id(int reply_id) {
		this.reply_id = reply_id;
	}
	/**
	 * @return the comment_data
	 */
	public String getComment_data() {
		return comment_data;
	}
	/**
	 * @param comment_data the comment_data to set
	 */
	public void setComment_data(String comment_data) {
		this.comment_data = comment_data;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(comment_data, reply_id, user_comment_id, user_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof UserComments)) {
			return false;
		}
		UserComments other = (UserComments) obj;
		return Objects.equals(comment_data, other.comment_data) && reply_id == other.reply_id
				&& user_comment_id == other.user_comment_id && user_id == other.user_id;
	}
	
	
	
}

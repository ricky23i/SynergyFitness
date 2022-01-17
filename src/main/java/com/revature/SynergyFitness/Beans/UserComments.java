package com.revature.SynergyFitness.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class UserComments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int user_comment_id;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Person user;
	
	@OneToMany
	@JoinColumn(name="user_comment_id")
	private List<UserComments> comment;
	
	private String comment_data;
	
	public UserComments() {
		user_comment_id=0;
		user=new Person();
		comment= new ArrayList<UserComments>();
		comment_data="";
		
	}
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
	public Person getUser() {
		return user;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser(Person user) {
		this.user = user;
	}
	/**
	 * @return the reply_id
	 */
	public List<UserComments> getComment() {
		return comment;
	}
	/**
	 * @param reply_id the reply_id to set
	 */
	public void setComment(List<UserComments> comment) {
		this.comment = comment;
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((comment_data == null) ? 0 : comment_data.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + user_comment_id;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserComments other = (UserComments) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (comment_data == null) {
			if (other.comment_data != null)
				return false;
		} else if (!comment_data.equals(other.comment_data))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (user_comment_id != other.user_comment_id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserComments [user_comment_id=" + user_comment_id + ", user=" + user + ", comment=" + comment
				+ ", comment_data=" + comment_data + "]";
	}
	
}

package com.revature.SynergyFitness.Beans;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int post_id;
	
	private Person user;
	
	private String post_data;
	
	
	public Post() {
		post_id=0;
		user=new Person();
		post_data="";
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(post_data, post_id, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(post_data, other.post_data) && post_id == other.post_id
				&& Objects.equals(user, other.user);
	}
	
	@Override
	public String toString() {
		return "Post [post_id=" + post_id + ", user=" + user + ", post_data=" + post_data + "]";
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public Person getUser() {
		return user;
	}


	public void setUser(Person user) {
		this.user = user;
	}


	public String getPost_data() {
		return post_data;
	}


	public void setPost_data(String post_data) {
		this.post_data = post_data;
	}
}

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
	private Post post;
	
	private Person user;
	
	private String post_data;
	
	
	public Post() {
		post= new Post();
		user=new Person();
		post_data="";
		
	}


	@Override
	public int hashCode() {
		return Objects.hash(post_data, post, user);
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
		return Objects.equals(post_data, other.post_data) && post == other.post
				&& Objects.equals(user, other.user);
	}
	
	@Override
	public String toString() {
		return "Post [post_id=" + post + ", user=" + user + ", post_data=" + post_data + "]";
	}

	public Post getPost_id() {
		return post;
	}

	public void setPost_id(Post post_id) {
		this.post = post_id;
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

package com.revature.SynergyFitness.Beans;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name="post_id")
	private int postId;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private Person user;
	
	@Column(name="post_data")
	private String postData;
	
	public Post() {
		postId = 0;
		user = new Person();
		postData="";
		
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public String getpostData() {
		return postData;
	}

	public void setpostData(String postData) {
		this.postData = postData;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + postId;
		result = prime * result + ((postData == null) ? 0 : postData.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Post other = (Post) obj;
		if (postId != other.postId)
			return false;
		if (postData == null) {
			if (other.postData != null)
				return false;
		} else if (!postData.equals(other.postData))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", user=" + user + ", postData=" + postData + "]";
	}

}
	



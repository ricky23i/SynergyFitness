package com.revature.SynergyFitness.Beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AboutMe {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aboutMeId;
	
	private String description;
	
	private int trainerAge;
	
	private String certs;
	
	private String experience;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private Person user;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="mediaId")
	private List<Media> media;
	
	public AboutMe () {
		aboutMeId = 0;
		description = "";
		trainerAge = 0;
		certs = "";
		experience = "";
		user = new Person();
		media = new ArrayList<Media>();
	}

	public int getAboutMeId() {
		return aboutMeId;
	}

	public void setAboutMeId(int aboutMeId) {
		this.aboutMeId = aboutMeId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTrainerAge() {
		return trainerAge;
	}

	public void setTrainerAge(int trainerAge) {
		this.trainerAge = trainerAge;
	}

	public String getCerts() {
		return certs;
	}

	public void setCerts(String certs) {
		this.certs = certs;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Person getUser() {
		return user;
	}

	public void setUser(Person user) {
		this.user = user;
	}

	public List<Media> getMedia() {
		return media;
	}

	public void setMedia(List<Media> media) {
		this.media = media;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aboutMeId;
		result = prime * result + ((certs == null) ? 0 : certs.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((experience == null) ? 0 : experience.hashCode());
		result = prime * result + ((media == null) ? 0 : media.hashCode());
		result = prime * result + trainerAge;
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
		AboutMe other = (AboutMe) obj;
		if (aboutMeId != other.aboutMeId)
			return false;
		if (certs == null) {
			if (other.certs != null)
				return false;
		} else if (!certs.equals(other.certs))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (experience == null) {
			if (other.experience != null)
				return false;
		} else if (!experience.equals(other.experience))
			return false;
		if (media == null) {
			if (other.media != null)
				return false;
		} else if (!media.equals(other.media))
			return false;
		if (trainerAge != other.trainerAge)
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
		return "AboutMe [aboutMeId=" + aboutMeId + ", description=" + description + ", trainerAge=" + trainerAge
				+ ", certs=" + certs + ", experience=" + experience + ", user=" + user + ", media=" + media + "]";
	}

}

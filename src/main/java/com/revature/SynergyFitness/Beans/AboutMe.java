package com.revature.SynergyFitness.Beans;

public class AboutMe {
	private int aboutMeId;
	private int userId;
	private int mediaId;
	private String description;
	private int trainerAge;
	private String certs;
	private String experience;
	
	public AboutMe () {
		aboutMeId = 0;
		userId = 0;
		mediaId = 0;
		description = "";
		trainerAge = 0;
		certs = "";
		experience = "";
	}

	public int getAboutMeId() {
		return aboutMeId;
	}

	public void setAboutMeId(int aboutMeId) {
		this.aboutMeId = aboutMeId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getMediaId() {
		return mediaId;
	}

	public void setMediaId(int mediaId) {
		this.mediaId = mediaId;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + aboutMeId;
		result = prime * result + ((certs == null) ? 0 : certs.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((experience == null) ? 0 : experience.hashCode());
		result = prime * result + mediaId;
		result = prime * result + trainerAge;
		result = prime * result + userId;
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
		if (mediaId != other.mediaId)
			return false;
		if (trainerAge != other.trainerAge)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "AboutMe [aboutMeId=" + aboutMeId + ", userId=" + userId + ", mediaId=" + mediaId + ", description="
				+ description + ", trainerAge=" + trainerAge + ", certs=" + certs + ", experience=" + experience + "]";
	}
}

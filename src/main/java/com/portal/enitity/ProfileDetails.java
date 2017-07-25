package com.portal.enitity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="profiledata")
public class ProfileDetails {
	@Id
	@Column(name = "profile_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long profileID;
	
	
	@Column(name="name")
	private String profileName;
	
	@Column(name="date_of_birth")
	private Date profileDOB;
	
	@Column(name="gender")
	private String profileGender;

	public Long getProfileID() {
		return profileID;
	}

	public void setProfileID(Long profileID) {
		this.profileID = profileID;
	}

	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public Date getProfileDOB() {
		return profileDOB;
	}

	public void setProfileDOB(Date profileDOB) {
		this.profileDOB = profileDOB;
	}

	public String getProfileGender() {
		return profileGender;
	}

	public void setProfileGender(String profileGender) {
		this.profileGender = profileGender;
	}
	
	

}

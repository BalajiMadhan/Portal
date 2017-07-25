package com.portal.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login")
public class Login {

	@Id
	@Column(name = "login_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long loginID;
	
	
	@Column(name="username")
	private String userName;
	
	@Column(name="password")
	private String password;


	@Column(name = "profile_id")
	private Long profileID;
	
	
	
	public Long getProfileID() {
		return profileID;
	}

	public void setProfileID(Long profileID) {
		this.profileID = profileID;
	}

	public Long getLoginID() {
		return loginID;
	}

	public void setLoginID(Long loginID) {
		this.loginID = loginID;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}

package com.portal.enitity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="login_profile")
public class UserProfile {
	
	
	@Id
	@Column(name = "table_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tableId;
	
	@Column(name = "profile_id")
	private Long profileId;
	
	@Column(name = "login_id")
	private Long loginId;

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public Long getLoginId() {
		return loginId;
	}

	public void setLoginId(Long loginId) {
		this.loginId = loginId;
	}
	
	

}

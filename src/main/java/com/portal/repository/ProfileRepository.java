package com.portal.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.portal.enitity.ProfileDetails;

public interface ProfileRepository extends CrudRepository<ProfileDetails, Serializable> {
	
	
	@Query("SELECT profile as profile FROM ProfileDetails profile WHERE profile.profileID=:profileId")
	public ProfileDetails getProfileData(@Param("profileId") Long profileId);
	
}

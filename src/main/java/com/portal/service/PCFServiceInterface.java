package com.portal.service;

import java.util.List;

import com.portal.enitity.CertificationDetails;
import com.portal.enitity.CourseData;
import com.portal.enitity.Login;
import com.portal.enitity.ProfileDetails;

public interface PCFServiceInterface {

	public Login loginValidate(String userName,String password);
	
	public int ProfileInsertion(ProfileDetails sendData);
	
	/*public List<CourseData> CourseData();*/
	public List<CourseData> CourseData(Long profilId);
	
	public int statusUpdate(Long CourseId);
	
/*	public List<CertificationDetails> certification();*/
	public List<CertificationDetails> certification(Long profileId);
	
	public int addCertification(CertificationDetails CertificationJson);
	
	public ProfileDetails getProfileDetails(Long profileId);
	
	public Login getUserData(String userName);
	
}

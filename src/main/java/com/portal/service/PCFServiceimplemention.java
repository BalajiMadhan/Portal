package com.portal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.enitity.CertificationDetails;
import com.portal.enitity.Login;
import com.portal.enitity.ProfileDetails;
import com.portal.repository.CertificationRepository;
import com.portal.repository.CourseRepository;
import com.portal.repository.LoginRepository;
import com.portal.repository.ProfileRepository;

@Service
public class PCFServiceimplemention implements PCFServiceInterface {

	@Autowired
	private LoginRepository loginRepo;

	@Autowired
	private ProfileRepository profileRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired
	private CertificationRepository certificationRepo;
	
	@Override
	public Login loginValidate(String userName,String password) {
		// TODO Auto-generated method stub
		
		

		return loginRepo.findOneByUserName(userName);
	}


	@Override
	public int ProfileInsertion(ProfileDetails sendData) {
		// TODO Auto-generated method stub
		ProfileDetails test=profileRepo.save(sendData);
		return 1;
	}

/*
	@Override
	public List<com.portal.enitity.CourseData> CourseData() {
		// TODO Auto-generated method stub
		
		
		return courseRepo.findAll();
	}*/


	@Override
	public int statusUpdate(Long CourseId) {
		// TODO Auto-generated method stub
		
		int status=1;
		
		int result=courseRepo.updateFilter(status, CourseId);
		
		if(result == 1){
			status=0;
			CourseId=CourseId+1;
			return courseRepo.updateFilter(status, CourseId);	
		}
		
		System.out.println("updateed status"+result);
		return 0;
	}


/*	@Override
	public List<CertificationDetails> certification() {
		// TODO Auto-generated method stub
		
		return certificationRepo.certificationList();
	}
*/
	
	@Override
	public List<CertificationDetails> certification(Long profileId) {
		// TODO Auto-generated method stub
		
		return certificationRepo.certificationList(profileId);
	}


	@Override
	public int addCertification(CertificationDetails CertificationJson) {
		// TODO Auto-generated method stub
		CertificationDetails test=certificationRepo.save(CertificationJson);
		return 1;
	}


	@Override
	public ProfileDetails getProfileDetails(Long profileId) {
		// TODO Auto-generated method stub
		return profileRepo.getProfileData(profileId);
	}


	@Override
	public Login getUserData(String userName) {
		// TODO Auto-generated method stub
		return loginRepo.findOneByUserName(userName);
	}


	@Override
	public List<com.portal.enitity.CourseData> CourseData(Long profilId) {
		// TODO Auto-generated method stub
		return courseRepo.courseDataList(profilId);
	}

}

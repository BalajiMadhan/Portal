package com.portal.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.portal.enitity.CertificationDetails;
import com.portal.enitity.Login;
import com.portal.enitity.ProfileDetails;
import com.portal.service.PCFServiceInterface;




@RestController
public class PCFPortalController {
	
	
	public Long userIdGolbal;
	
	public String userNameGolbal;
	
	public Long profileIdGolbal;
	
	@Autowired
	private PCFServiceInterface PCFService;

	
	@RequestMapping(value ="/LoginValidate/{userName}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Long LoginValidateController(@PathVariable String userName,@PathVariable String password){
		System.out.println("hi"+userName);
		System.out.println("hi"+password);
		Login test=PCFService.loginValidate(userName,password);
		
		if(test.getPassword().equalsIgnoreCase(password)){
			Long userId=test.getLoginID();
			userIdGolbal=test.getLoginID();
			userNameGolbal=test.getUserName();
			profileIdGolbal=test.getProfileID();
			return userId;
		}else {
			Long user=(long) 0;
			return user;
		}
	}
	
	
	@RequestMapping(value ="/ProfileCreation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int ProfileCreation(@RequestBody final ProfileDetails profileData){
		
		System.out.println(profileData.getProfileName()+"sample ");
		ProfileDetails sendData=new ProfileDetails();
		sendData.setProfileName(profileData.getProfileName());
		sendData.setProfileDOB(profileData.getProfileDOB());
		sendData.setProfileGender(profileData.getProfileGender());
		
		
	return PCFService.ProfileInsertion(sendData);
	}
	
/*	@RequestMapping(value ="/TrainingData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<com.portal.enitity.CourseData> CourseData(){
		
		return PCFService.CourseData();
	}
	*/
	
	@RequestMapping(value ="/TrainingData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<com.portal.enitity.CourseData> CourseData(){
		
		return PCFService.CourseData(profileIdGolbal);
	}
	
	
	@RequestMapping(value ="/StatusUpdate/{CourseId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public int StatusUpdate(@PathVariable Long CourseId){
		System.out.println(CourseId);
		return PCFService.statusUpdate(CourseId);
	}
	
	/*@RequestMapping(value="/certification",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public int certificationDetails(){
		Long profileId=(long) 1;
		List<CertificationDetails> test=PCFService.certification();
		return 1;
	}*/
	
	
	@RequestMapping(value="/certification/{profileId}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CertificationDetails> certificationDetails(@PathVariable Long profileId){
		
		System.out.println("in controller"+profileId);
		List<CertificationDetails> sample=PCFService.certification(profileIdGolbal);
		for(CertificationDetails i:sample){
			System.out.println(i.getCertificationendDate());
			System.out.println(i.getCertificationName());
			System.out.println(i.getCertificationstartDate());
			System.out.println(i.getCertificationID());
		}
		return sample;
	}
	
	
	@RequestMapping(value ="/CertificationUpdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public int CertificationUpdate(@RequestBody final CertificationDetails CertificationJson){	
	
		CertificationJson.setpId(profileIdGolbal);
		return PCFService.addCertification(CertificationJson);
	}
	
	
	@RequestMapping(value ="/ProfileData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ProfileDetails 	getProfileData(){
		
	return PCFService.getProfileDetails(profileIdGolbal);
	}
	

	
	@RequestMapping(value ="/userNameDisplay", method = RequestMethod.GET, produces = MediaType.TEXT_PLAIN_VALUE)
	public String userNameDisplay(){
		
	return userNameGolbal;
	}
	
	
	@RequestMapping(value ="/userData", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Login getuserData(){
	return PCFService.getUserData(userNameGolbal);
	}
	
	

}

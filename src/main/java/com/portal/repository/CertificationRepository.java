package com.portal.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.portal.enitity.CertificationDetails;



public interface CertificationRepository extends CrudRepository<CertificationDetails, Serializable> {

	
	
	
	/*@Query("SELECT  certification as certification FROM CertificationDetails certification")
	public List<CertificationDetails> certificationList();*/
	
	
	@Query("SELECT  certification as certification FROM CertificationDetails certification WHERE certification.pId=?1")
	public List<CertificationDetails> certificationList(Long profileid);
}

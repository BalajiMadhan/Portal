package com.portal.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.portal.enitity.CertificationDetails;
import com.portal.enitity.CourseData;

public interface CourseRepository extends CrudRepository<CourseData, Serializable> {
	
	
	public List<CourseData> findAll();
	
	
	@Modifying
	@Transactional
	@Query("UPDATE CourseData c SET c.status=?1 WHERE c.courseID=?2")
	public int updateFilter(int status,Long CourseId);
	
	
	
	
	@Query("SELECT course as course FROM CourseData course  WHERE course.profileID=?1")
	public List<CourseData> courseDataList(Long profilId);

}

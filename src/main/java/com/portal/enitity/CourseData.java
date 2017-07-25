package com.portal.enitity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="coursedata")
public class CourseData {
	
	
	@Id
	@Column(name = "course_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long courseID;
	
	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "course_link")
	private String courseLink;
	
	@Column(name = "course_startdate")
	private Date startDate;
	
	@Column(name = "course_enddate")
	private Date endDate;
	
	@Column(name = "status")
	private int status;
	
	@Column(name = "profile_id")
	private Long profileID;

	public Long getProfileID() {
		return profileID;
	}

	public void setProfileID(Long profileID) {
		this.profileID = profileID;
	}

	public Long getCourseID() {
		return courseID;
	}

	public void setCourseID(Long courseID) {
		this.courseID = courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseLink() {
		return courseLink;
	}

	public void setCourseLink(String courseLink) {
		this.courseLink = courseLink;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	

}

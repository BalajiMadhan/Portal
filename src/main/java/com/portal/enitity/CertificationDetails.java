package com.portal.enitity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="certification")
public class CertificationDetails {
		
		@Id
		@Column(name = "certification_id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long certificationID;
		
		@Column(name = "certification_name")
		private String certificationName;
		
		@Column(name = "certification_date")
		private Date certificationstartDate;
		
		@Column(name = "certification_expiry")
		private Date certificationendDate;
		
		@Column(name = "profile_id")
		private Long pId;

		public Long getCertificationID() {
			return certificationID;
		}

		public void setCertificationID(Long certificationID) {
			this.certificationID = certificationID;
		}

		public String getCertificationName() {
			return certificationName;
		}

		public void setCertificationName(String certificationName) {
			this.certificationName = certificationName;
		}

		public Date getCertificationstartDate() {
			return certificationstartDate;
		}

		public void setCertificationstartDate(Date certificationstartDate) {
			this.certificationstartDate = certificationstartDate;
		}

		public Date getCertificationendDate() {
			return certificationendDate;
		}

		public void setCertificationendDate(Date certificationendDate) {
			this.certificationendDate = certificationendDate;
		}

		public Long getpId() {
			return pId;
		}

		public void setpId(Long pId) {
			this.pId = pId;
		}

		
}

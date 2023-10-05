package com.ob.app.partner.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
public class PointOfContact {
	
	@Id
	@Column(name = "id")
	private int pointOfContactId;
	
	@NotEmpty(message = "comapany name is required")
	@Column(name = "company_name")
	private String companyName;
	

	@Min(value = 1000000000L, message = "Contact number is too small")
	@Max(value = 9999999999L, message = "Contact number is too large")
	@Positive(message = "mobile number must be positive")
	@NotNull(message = "mobile number is required")
	@Column(name = "mobile_no")
	private long mobileNo;
	
	@NotEmpty(message = "email id is required")
	@Email
	@Column(name = "emaild_id",unique = true, nullable = false)
	private String emaildId;
	
	
	
	public PointOfContact() {

	}

	public PointOfContact(int pointOfContactId, String companyName, long mobileNo, String emaildId) {
		super();
		this.pointOfContactId = pointOfContactId;
		this.companyName = companyName;
		this.mobileNo = mobileNo;
		this.emaildId = emaildId;
	}

	public int getPointOfContactId() {
		return pointOfContactId;
	}

	public void setPointOfContactId(int pointOfContactId) {
		this.pointOfContactId = pointOfContactId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmaildId() {
		return emaildId;
	}

	public void setEmaildId(String emaildId) {
		this.emaildId = emaildId;
	}

	@Override
	public String toString() {
		return "PointOfContact [pointOfContactId=" + pointOfContactId + ", companyName=" + companyName + ", mobileNo="
				+ mobileNo + ", emaildId=" + emaildId + "]";
	}
	
}

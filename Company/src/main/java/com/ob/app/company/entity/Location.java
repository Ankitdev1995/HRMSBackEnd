package com.ob.app.company.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "location")
public class Location {
	
	@Id
	private int locationId;
	
	@NotEmpty(message = "location name is required")
	@Column(name = "location_name", nullable = false)
	private String locationName;
	
	@NotEmpty(message = "address line 1 is required")
	@Column(name = "address_line_1" , nullable = false)
	private String addressLine1;
	
	@NotEmpty(message = "address line 2 is required")
	@Column(name = "address_line_2" , nullable = false)
	private String addressLine2;
	
	@NotEmpty(message = "region is required")
	@Column(name = "region" , nullable = false)
	private String region;
	
	@NotEmpty(message = "country is required")
	@Column(name = "country" , nullable = false)
	private String country;
	
	@NotEmpty(message = "state is required")
	@Column(name = "state" , nullable = false)
	private String state;
	
	@NotEmpty(message =  "city is required")
	@Column(name = "city" , nullable = false)
	private String city;
	
	@NotNull(message = "Pincode is required")
	@Column(name = "pin" , nullable = false)
	private long pin;
	
	@Min(value = 1000000000L, message = "Contact number is too small")
	@Max(value = 9999999999L, message = "Contact number is too large")
	@Positive(message = "Contact number must be positive")
	@NotNull(message = "contact number 1 is required")
	@Column(name = "contact_no_1" , nullable = false)
	private long contactNo1;
	
	@Min(value = 1000000000L, message = "Contact number is too small")
	@Max(value = 9999999999L, message = "Contact number is too large")
	@Positive(message = "Contact number must be positive")
	@NotNull(message = "contact number 2 is required")
	@Column(name = "contact_no_2", nullable = false)
	private long contactNo2;
	

	@Min(value = 1000000000L, message = "Contact number is too small")
	@Max(value = 9999999999L, message = "Contact number is too large")
	@Positive(message = "Contact number must be positive")
	@NotNull(message = "contact number 3 is required")
	@Column(name = "contact_no_3" , nullable = false)
	private long contactNo3;
	
	@Email
	@NotEmpty(message = "email is required ")
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	
	
	
	public Location() {
		
	}
	
	public Location(int locationId, String locationName, String addressLine1, String addressLine2, String region,
			String country, String state, String city, long pin, long contactNo1, long contactNo2, long contactNo3,
			String email) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.region = region;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pin = pin;
		this.contactNo1 = contactNo1;
		this.contactNo2 = contactNo2;
		this.contactNo3 = contactNo3;
		this.email = email;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getPin() {
		return pin;
	}

	public void setPin(long pin) {
		this.pin = pin;
	}

	public long getContactNo1() {
		return contactNo1;
	}

	public void setContactNo1(long contactNo1) {
		this.contactNo1 = contactNo1;
	}

	public long getContactNo2() {
		return contactNo2;
	}

	public void setContactNo2(long contactNo2) {
		this.contactNo2 = contactNo2;
	}

	public long getContactNo3() {
		return contactNo3;
	}

	public void setContactNo3(long contactNo3) {
		this.contactNo3 = contactNo3;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", addressLine1="
				+ addressLine1 + ", addressLine2=" + addressLine2 + ", region=" + region + ", country=" + country
				+ ", state=" + state + ", city=" + city + ", pin=" + pin + ", contactNo1=" + contactNo1
				+ ", contactNo2=" + contactNo2 + ", contactNo3=" + contactNo3 + ", email=" + email + "]";
	}
	
	
}

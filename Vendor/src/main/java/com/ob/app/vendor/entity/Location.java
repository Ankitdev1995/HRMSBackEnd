package com.ob.app.vendor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
 
@Entity
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int locationId;
	
//	@NotEmpty(message = "address is required")
	@Column(name = "address_line1")
	private String addressLine1;
	
	@NotEmpty(message = "address is required")
	@Column(name = "address_line2")
	private String addressLine2;
	
	@NotEmpty(message = "region is required")
	@Column(name = "region")
	private String region;
	
	@NotEmpty(message = "country is required")
	@Column(name = "country")
	private String country;

	@NotEmpty(message = "state is required")
	@Column(name = "state")
	private String state;
	
	@NotEmpty(message = "city is required")
	@Column(name = "city")
	private String city;
	
	@NotEmpty(message = "pincode is required")
	@Column(name = "pincode")
	private String pin;


	public Location() {

	}

	public Location(int locationId, String addressLine1, String addressLine2, String region, String country,
			String state, String city, String pin) {
		super();
		this.locationId = locationId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.region = region;
		this.country = country;
		this.state = state;
		this.city = city;
		this.pin = pin;
	}



	public int getLocationId() {
		return locationId;
	}


	public void setLocationId(int locationId) {
		this.locationId = locationId;
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


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", region=" + region + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", pin=" + pin + "]";
	} 
}

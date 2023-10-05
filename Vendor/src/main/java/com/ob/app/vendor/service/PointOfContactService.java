package com.ob.app.vendor.service;

import java.util.List;

import com.ob.app.vendor.entity.PointOfContact;

public interface PointOfContactService {

	public PointOfContact savePointOfContact(PointOfContact pointOfContact);
	
	public PointOfContact updatePointOfContact(PointOfContact pointOfContact,int pointOfContactId);
	
	public List<PointOfContact> getAllPointOfContact();
	
	public boolean deletePointOfContact(int pointOfContactId);
	
	public List<PointOfContact> getPointOfContactCompanyName(String companyName);

}

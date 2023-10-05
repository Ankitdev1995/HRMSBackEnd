package com.ob.app.company.services;

import java.util.List;
import java.util.Optional;

import com.ob.app.company.entity.Designation;

public interface DesignationService {

	public Designation saveDesignation(Designation designation);
	
	public String deleteDesignation(int designationId);
	
	public List<Designation> getAllDesignation();
	
	public List<Designation> getDesignationByGroupName(String groupName);
	
	public Optional<Designation> getDesignationById(int designationId);
	
}

package com.ob.app.company.services;

import java.util.List;

import com.ob.app.company.entity.DesignationGroup;

public interface DesignationGroupService {

	public DesignationGroup saveDesignationGroup(DesignationGroup designationGroup);

	public String deleteDesignationGroup(int designationGroupId);

	public List<DesignationGroup> getAllDesginationGroup();

}

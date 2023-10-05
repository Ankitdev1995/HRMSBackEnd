package com.ob.app.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class DesignationGroup {
	
	@Id
	private int designationGroupId;
	
	@NotEmpty(message = "designation group name is required")
	@Column(name = "designation_group_name")
	private String designationGroupName;
	
	@NotEmpty(message = "description is required")
	@Column(name  = "description")
	private String description;
	
	public DesignationGroup() {
		
	}

	public DesignationGroup(int designationGroupId, String designationGroupName, String description) {
		super();
		this.designationGroupId = designationGroupId;
		this.designationGroupName = designationGroupName;
		this.description = description;
	}

	public int getDesignationGroupId() {
		return designationGroupId;
	}

	public void setDesignationGroupId(int designationGroupId) {
		this.designationGroupId = designationGroupId;
	}

	public String getDesignationGroupName() {
		return designationGroupName;
	}

	public void setDesignationGroupName(String designationGroupName) {
		this.designationGroupName = designationGroupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DesignationGroup [DesignationGroupId=" + designationGroupId + ", designationGroupName="
				+ designationGroupName + ", description=" + description + "]";
	}
}

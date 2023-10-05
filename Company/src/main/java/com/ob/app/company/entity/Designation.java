package com.ob.app.company.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Designation {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int designationId;	
	
	@NotEmpty(message = "designation name is required")
	@Column(name = "designation_name")
	private String designationName;
	
	@NotEmpty(message = "group name is required")
	@Column(name = "group_name")
	private String groupName;
	
	@NotEmpty(message = "description is required")
	@Column(name = "description")
	private String description;
	
	@ManyToOne	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Department departments;
	
	public Designation() {
	
	}
	
	public Designation(int designationId, @NotEmpty(message = "designation name is required") String designationName,
			@NotEmpty(message = "group name is required") String groupName,
			@NotEmpty(message = "description is required") String description, Department departments) {
		super();
		this.designationId = designationId;
		this.designationName = designationName;
		this.groupName = groupName;
		this.description = description;
		this.departments = departments;
	}



	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department getDepartments() {
		return departments;
	}

	public void setDepartments(Department departments) {
		this.departments = departments;
	}
	
}

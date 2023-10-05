package com.ob.app.company.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

	@Id
	@Column(name = "DEPARTMENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int departmentId;

	@NotEmpty(message = "department name is required")
	@Column(name = "department_name", nullable = false)
	private String departmentName;

	@NotEmpty(message = "description is required")
	@Column(name = "description", nullable = false)
	private String description;

	@ManyToOne
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private CompanyBasicDetails companyBasicDetails;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "department_designation_tbl", joinColumns = @JoinColumn(name = "departmentId"), inverseJoinColumns = @JoinColumn(name = "designationId"))
	private List<Designation> designation;

	public Department() {

	}

	public Department(int departmentId, @NotEmpty(message = "department name is required") String departmentName,
			@NotEmpty(message = "description is required") String description, CompanyBasicDetails companyBasicDetails,
			List<Designation> designation) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.description = description;
		this.companyBasicDetails = companyBasicDetails;
		this.designation = designation;

	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public CompanyBasicDetails getCompanyBasicDetails() {
		return companyBasicDetails;
	}

	public void setCompanyBasicDetails(CompanyBasicDetails companyBasicDetails) {
		this.companyBasicDetails = companyBasicDetails;
	}

	public List<Designation> getDesignation() {
		return designation;
	}

	public void setDesignation(List<Designation> designation) {
		this.designation = designation;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + ", description="
				+ description + "]";
	}

}

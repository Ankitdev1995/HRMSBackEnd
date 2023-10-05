package com.ob.app.company.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "COMPANY")
public class CompanyBasicDetails {
	
		@Id
		@GeneratedValue(strategy =  GenerationType.AUTO)
		@Column(name = "COMPANY_ID")
		private Integer companyId;
		
		@NotEmpty(message = "company name is required")
		@Column(name = "company_name")
		private String companyName;
		
		@NotEmpty(message = "abbrivation is required")
		@Column(name = "abbrivation")
		private String abbrivation;
		
		@NotNull(message = "date is required")
		@Temporal(TemporalType.DATE)
		@Column(name = "date_of_Incorporation")
		private Date dateOfIncorporation;
	
		@NotEmpty(message = "website is required")
		@Column(name = "website")
		private String website;
		
		@OneToOne
		private Location location;
		
		@OneToMany(cascade = CascadeType.ALL)
		@JoinTable(name = "comapany_department_tbl", joinColumns = @JoinColumn(name = "companyId"),
													inverseJoinColumns = @JoinColumn(name = "departmentId"))
		private List<Department> departments;
		

		public CompanyBasicDetails() {
		
		}
	
		public CompanyBasicDetails(Integer companyId,
				@NotEmpty(message = "company name is required") String companyName,
				@NotEmpty(message = "abbrivation is required") String abbrivation,
				@NotNull(message = "date is required") Date dateOfIncorporation,
				@NotEmpty(message = "website is required") String website, Location location,
				List<Department> departments) {
			super();
			this.companyId = companyId;
			this.companyName = companyName;
			this.abbrivation = abbrivation;
			this.dateOfIncorporation = dateOfIncorporation;
			this.website = website;
			this.location = location;
			this.departments = departments;
		}  




		public Integer getCompanyId() {
			return companyId;
		}

		public void setCompanyId(Integer companyId) {
			this.companyId = companyId;
		}

		public String getCompanyName() {
			return companyName;
		}

		public void setCompanyName(String companyName) {
			this.companyName = companyName;
		}

		public String getAbbrivation() {
			return abbrivation;
		}

		public void setAbbrivation(String abbrivation) {
			this.abbrivation = abbrivation;
		}

		public Date getDateOfIncorporation() {
			return dateOfIncorporation;
		}

		public void setDateOfIncorporation(Date dateOfIncorporation) {
			this.dateOfIncorporation = dateOfIncorporation;
		}

		public String getWebsite() {
			return website;
		}

		public void setWebsite(String website) {
			this.website = website;
		}

		public Location getLocation() {
			return location;
		}

		public void setLocation(Location location) {
			this.location = location;
		}

		public List<Department> getDepartments() {
			return departments;
		}

		public void setDepartments(List<Department> departments) {
			this.departments = departments;
		}

		@Override
		public String toString() {
			return "CompanyBasicDetails [companyId=" + companyId + ", companyName=" + companyName + ", abbrivation="
					+ abbrivation + ", dateOfIncorporation=" + dateOfIncorporation + ", website=" + website
					+ ", location=" + location + "]";
		}
		
		
}

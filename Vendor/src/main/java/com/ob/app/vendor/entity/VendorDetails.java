package com.ob.app.vendor.entity;

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
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "vendor_Info")
public class VendorDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "vendor_id")
	private int id;
	
	@NotEmpty(message = "vendor name is required")
	@Column(name = "vendor_ name")
	private String vendorName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "vendor_pointOfContact_tbl" ,joinColumns = @JoinColumn(name = "id"),
													inverseJoinColumns = @JoinColumn(name = "pointOfContactId"))
	private List<PointOfContact> pointOfContacts;
	
	public VendorDetails() {
		
	}
	
	
	public VendorDetails(int id, @NotEmpty(message = "vendor name is required") String vendorName,
			List<PointOfContact> pointOfContacts) {
		super();
		this.id = id;
		this.vendorName = vendorName;
		this.pointOfContacts = pointOfContacts;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	
	
	public List<PointOfContact> getPointOfContacts() {
		return pointOfContacts;
	}

	public void setPointOfContacts(List<PointOfContact> pointOfContacts) {
		this.pointOfContacts = pointOfContacts;
	}

	@Override
	public String toString() {
		return "VendorDetails [id=" + id + ", vendorName=" + vendorName + "]";
	}
}

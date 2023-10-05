package com.ob.app.partner.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "partner_Info")
public class PartnerDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "partner_id")
	private int id;
	
	@NotEmpty(message = "partner name is required")
	@Column(name = "partner_ name")
	private String partnerName;
		
	public PartnerDetails() {
		
	}
	
	public PartnerDetails(int id, String partnerName) {
		super();
		this.id = id;
		this.partnerName = partnerName;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	@Override
	public String toString() {
		return "PartnerDetails [id=" + id + ", partnerName=" + partnerName + "]";
	}
	

}

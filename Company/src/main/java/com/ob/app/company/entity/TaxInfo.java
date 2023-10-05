package com.ob.app.company.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TaxInfo {
	
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id ;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "value")
	private String value;
	
	public TaxInfo() {
	
	}
	public TaxInfo(long id, String name, String value) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

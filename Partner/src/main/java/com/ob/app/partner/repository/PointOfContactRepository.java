package com.ob.app.partner.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ob.app.partner.entity.PointOfContact;

public interface PointOfContactRepository extends JpaRepository<PointOfContact, Integer>{
	
	public List<PointOfContact> findBycompanyName(String companyName);
	
	
}

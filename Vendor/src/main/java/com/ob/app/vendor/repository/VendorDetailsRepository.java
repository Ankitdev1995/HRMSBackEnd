package com.ob.app.vendor.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ob.app.vendor.entity.VendorDetails;

public interface VendorDetailsRepository extends JpaRepository<VendorDetails, Integer>{

	public Optional<VendorDetails> findByVendorName(String vendorName);
	
	

}

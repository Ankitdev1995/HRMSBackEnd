package com.ob.app.vendor.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.app.vendor.entity.VendorDetails;
import com.ob.app.vendor.repository.VendorDetailsRepository;
import com.ob.app.vendor.service.VendorDetailsService;

@Service
public class VendorDetailsServiceImpl implements VendorDetailsService{

	@Autowired
	private	VendorDetailsRepository vendorDetailsRepository;

	@Override
	public VendorDetails saveVendor(VendorDetails vendorDetails) {
		VendorDetails  savepartnerDetails =	vendorDetailsRepository.save(vendorDetails);
		return savepartnerDetails;
	}

	@Override
	public Optional<VendorDetails> getLocationByName(String vendorName) {
	return	vendorDetailsRepository.findByVendorName(vendorName);
	}

	@Override
	public List<VendorDetails> getAllVendors() {
	List<VendorDetails> getpartners = vendorDetailsRepository.findAll();
		return getpartners;
	}

	@Override
	public Optional<VendorDetails> getvendorById(Integer id) {
		return vendorDetailsRepository.findById(id);
	}

	
}

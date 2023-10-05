package com.ob.app.vendor.service;

import java.util.List;
import java.util.Optional;
import com.ob.app.vendor.entity.VendorDetails;

public interface VendorDetailsService {

	public VendorDetails saveVendor(VendorDetails vendorDetails);

	public Optional<VendorDetails> getLocationByName(String vendorName);
	
	public List<VendorDetails> getAllVendors();
	
	public Optional<VendorDetails> getvendorById(Integer id);
}

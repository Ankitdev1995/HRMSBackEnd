package com.ob.app.vendor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ob.app.vendor.entity.VendorDetails;
import com.ob.app.vendor.exception.LocationNotFoundException;
import com.ob.app.vendor.service.VendorDetailsService;

@RestController
@RequestMapping("/api/vendor")
public class VendorDetailsController {

	@Autowired
	private VendorDetailsService vendorDetailsService;

	@PostMapping("/saved")
	public ResponseEntity<String> saveVendorDetails(@RequestBody VendorDetails vendorDetails ){
		VendorDetails saveVendor = vendorDetailsService.saveVendor(vendorDetails);
		if(saveVendor!=null) {
			return new ResponseEntity<String>("vendor details is saved", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Please enter vendor details", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/byname/{vendorName}")
	public ResponseEntity<VendorDetails> getCompanyByName(@PathVariable String vendorName) {
		Optional<VendorDetails> companyOptional = vendorDetailsService.getLocationByName(vendorName);

		if (companyOptional.isPresent()) {
			VendorDetails company = companyOptional.get();
			return ResponseEntity.ok(company);
		} else {
			throw new LocationNotFoundException("location is not found with vendor name : "+ vendorName);
		}
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<VendorDetails>> getPartnerDetails(){
		List<VendorDetails> getvendors = vendorDetailsService.getAllVendors();
		return new ResponseEntity<List<VendorDetails>>(getvendors, HttpStatus.OK);
	}
	
	@GetMapping("/vend/{id}")
	public ResponseEntity<VendorDetails> getVendorById(@PathVariable int id){
		Optional<VendorDetails> vendorById = vendorDetailsService.getvendorById(id);
		
		if(vendorById.isPresent()) {
			return new ResponseEntity<>(vendorById.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity("vendor is not found with given id :" + id, HttpStatus.NOT_FOUND);
		}
	}
}

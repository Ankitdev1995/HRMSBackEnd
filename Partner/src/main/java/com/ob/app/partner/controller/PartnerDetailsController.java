package com.ob.app.partner.controller;

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

import com.ob.app.partner.entity.PartnerDetails;
import com.ob.app.partner.exception.LocationNotFoundException;
import com.ob.app.partner.service.PartnerDetailsService;

@RestController
@RequestMapping("/api/partner")
public class PartnerDetailsController {

	@Autowired
	private PartnerDetailsService partnerDetailsService;

	@PostMapping("/saved")
	public ResponseEntity<String> savePartnerDetails(@RequestBody PartnerDetails partnerDetails ){
		PartnerDetails savePartner = partnerDetailsService.savePartner(partnerDetails);
		if(savePartner!=null) {
			return new ResponseEntity<String>("partner details is saved", HttpStatus.CREATED);
		}else {
			return new ResponseEntity<String>("Please enter partner details", HttpStatus.BAD_REQUEST);
		}
	}
	@GetMapping("/byname/{partnerName}")
	public ResponseEntity<PartnerDetails> getCompanyByName(@PathVariable String partnerName) {
		Optional<PartnerDetails> companyOptional = partnerDetailsService.getLocationByName(partnerName);

		if (companyOptional.isPresent()) {
			PartnerDetails company = companyOptional.get();
			return ResponseEntity.ok(company);
		} else {
			throw new LocationNotFoundException("location is not found with company name "+ partnerName);
		}
	}
	
	@GetMapping("/get")
	public ResponseEntity<List<PartnerDetails>> getPartnerDetails(){
		List<PartnerDetails> getpartners = 	partnerDetailsService.getAllPartners();
		return new ResponseEntity<List<PartnerDetails>>(getpartners, HttpStatus.OK);
		
	}
}

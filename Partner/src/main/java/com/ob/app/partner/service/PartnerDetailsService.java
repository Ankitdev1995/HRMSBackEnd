package com.ob.app.partner.service;

import java.util.List;
import java.util.Optional;

import com.ob.app.partner.entity.PartnerDetails;

public interface PartnerDetailsService {

	public PartnerDetails savePartner(PartnerDetails partnerDetails);

	public Optional<PartnerDetails> getLocationByName(String partnerName);
	
	public List<PartnerDetails> getAllPartners();
	

}

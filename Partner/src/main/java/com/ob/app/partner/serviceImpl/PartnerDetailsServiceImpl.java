package com.ob.app.partner.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.app.partner.entity.PartnerDetails;
import com.ob.app.partner.repository.PartnerDetailsRepository;
import com.ob.app.partner.service.PartnerDetailsService;


@Service
public class PartnerDetailsServiceImpl implements PartnerDetailsService{

	@Autowired
	private	PartnerDetailsRepository partnerDetailsRepository;

	@Override
	public PartnerDetails savePartner(PartnerDetails partnerDetails) {
		PartnerDetails  savepartnerDetails=	partnerDetailsRepository.save(partnerDetails);
		return savepartnerDetails;
	}

	@Override
	public Optional<PartnerDetails> getLocationByName(String partnerName) {
	return	partnerDetailsRepository.findByPartnerName(partnerName);
	}

	@Override
	public List<PartnerDetails> getAllPartners() {
	List<PartnerDetails> getpartners = 	partnerDetailsRepository.findAll();
		return getpartners;
	}
}

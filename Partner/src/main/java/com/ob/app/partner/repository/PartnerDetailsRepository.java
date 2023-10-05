package com.ob.app.partner.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ob.app.partner.entity.PartnerDetails;

public interface PartnerDetailsRepository extends JpaRepository<PartnerDetails, Integer>{

	public Optional<PartnerDetails> findByPartnerName(String partnerName);
	

}

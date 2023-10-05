package com.ob.app.company.repository;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ob.app.company.entity.CompanyBasicDetails;


public interface CompanyBasicDetailsRepository extends JpaRepository<CompanyBasicDetails, Integer>{
	
	 List<CompanyBasicDetails> findByCompanyName(String companyName);
	 
	

}

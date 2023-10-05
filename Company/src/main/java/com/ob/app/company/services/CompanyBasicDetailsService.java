package com.ob.app.company.services;


import java.util.List;
import java.util.Optional;

import com.ob.app.company.entity.CompanyBasicDetails;


public interface CompanyBasicDetailsService {

	public CompanyBasicDetails saveDetails(CompanyBasicDetails companyBasicDetails);
	
	public Optional<CompanyBasicDetails> getCompanyById(Integer companyId);
	
	public List<CompanyBasicDetails> getCompanyByName(String companyName);
	
	public List<CompanyBasicDetails> getAllcompany();
	
	public List<CompanyBasicDetails> gellAllCompaniesPaging(Integer pageNumber ,Integer pageSize);
	
}

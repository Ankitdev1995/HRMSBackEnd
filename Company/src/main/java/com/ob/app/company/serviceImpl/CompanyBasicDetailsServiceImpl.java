package com.ob.app.company.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ob.app.company.entity.CompanyBasicDetails;
import com.ob.app.company.repository.CompanyBasicDetailsRepository;
import com.ob.app.company.services.CompanyBasicDetailsService;

@Service
public class CompanyBasicDetailsServiceImpl implements CompanyBasicDetailsService{
	
	@Autowired
	private CompanyBasicDetailsRepository companyBasicDetailsRepository;
	
	@Override
	public CompanyBasicDetails saveDetails(CompanyBasicDetails companyBasicDetails) {
		CompanyBasicDetails saveDetails = companyBasicDetailsRepository.save(companyBasicDetails);
		return saveDetails;
	}

	@Override
	public Optional<CompanyBasicDetails> getCompanyById(Integer companyId) {
	return 	companyBasicDetailsRepository.findById(companyId);
		
	}

	@Override
	public List<CompanyBasicDetails> getCompanyByName(String companyName) {
		List<CompanyBasicDetails> cmpname = companyBasicDetailsRepository.findByCompanyName(companyName);
		return cmpname;
	}

	@Override
	public List<CompanyBasicDetails> getAllcompany() {
		List<CompanyBasicDetails> findAllComapny = companyBasicDetailsRepository.findAll();
		
		return findAllComapny;
	}

	@Override
	public List<CompanyBasicDetails> gellAllCompaniesPaging(Integer pageNumber, Integer pageSize) {
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		
	return this.companyBasicDetailsRepository.findAll(pageable).get().toList();

	}
}
	
	

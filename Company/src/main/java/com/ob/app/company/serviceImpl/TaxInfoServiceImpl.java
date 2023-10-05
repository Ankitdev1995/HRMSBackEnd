package com.ob.app.company.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.app.company.entity.TaxInfo;
import com.ob.app.company.repository.TaxInfoRepository;
import com.ob.app.company.services.TaxService;

@Service
public class TaxInfoServiceImpl implements TaxService{

	@Autowired
	private TaxInfoRepository taxInfoRepository;

	@Override
	public TaxInfo saveTaxInfo(TaxInfo taxInfo) {
		TaxInfo taxSaved = taxInfoRepository.save(taxInfo);
		return taxSaved;
	}

	@Override
	public String deleteTaxInfo(long id) {
		taxInfoRepository.deleteById(id);
		return "delete taxInfo with id" ;
	}
}

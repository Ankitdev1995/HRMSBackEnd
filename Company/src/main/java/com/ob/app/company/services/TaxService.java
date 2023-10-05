package com.ob.app.company.services;

import com.ob.app.company.entity.TaxInfo;

public interface TaxService {

	public TaxInfo saveTaxInfo(TaxInfo taxInfo);

	public String deleteTaxInfo(long id);

}

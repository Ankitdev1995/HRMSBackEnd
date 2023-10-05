package com.ob.app.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ob.app.company.entity.TaxInfo;
import com.ob.app.company.services.TaxService;

@RestController
@RequestMapping("/api/company")
public class TaxInfoController {

	@Autowired
	private TaxService taxService;

	@PostMapping("/new")
	public 	ResponseEntity<TaxInfo> savedTaxInfo(@RequestBody TaxInfo taxInfo){
		TaxInfo SavedTaxInfo = taxService.saveTaxInfo(taxInfo);
		return new ResponseEntity<TaxInfo>(SavedTaxInfo, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTaxInfo(@PathVariable long id){
		String deleteTaxInfo =  taxService.deleteTaxInfo(id);
		return new ResponseEntity<String>(deleteTaxInfo, HttpStatus.OK);
	}

}
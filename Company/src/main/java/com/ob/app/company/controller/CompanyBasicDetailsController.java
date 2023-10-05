package com.ob.app.company.controller;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ob.app.company.entity.CompanyBasicDetails;
import com.ob.app.company.exception.CompanyNameNotFoundException;
import com.ob.app.company.services.CompanyBasicDetailsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class CompanyBasicDetailsController {

	@Autowired
	private CompanyBasicDetailsService companyBasicDetailsService;
	
	@PostMapping("/save")
	public ResponseEntity<CompanyBasicDetails> saveDetails (@Valid @RequestBody CompanyBasicDetails  companyBasicDetails){
		CompanyBasicDetails savecompanyDetails = companyBasicDetailsService.saveDetails(companyBasicDetails);
		if(savecompanyDetails!= null) {
			return new ResponseEntity<CompanyBasicDetails>(savecompanyDetails, HttpStatus.CREATED);
		}else {
			throw new CompanyNameNotFoundException("company is not found ");
		}
	}	
	
	 @GetMapping("/{companyId}")
	    public ResponseEntity<CompanyBasicDetails> getCompanyById(@PathVariable int companyId) {
		 Optional<CompanyBasicDetails> getcompany =  companyBasicDetailsService.getCompanyById(companyId);
      if (getcompany.isPresent()) {
	            return ResponseEntity.ok(getcompany.get());
	        } else {
	        	throw new CompanyNameNotFoundException("company is not found with id: " +companyId);
	        }
	    } 
	 
	 @GetMapping("/getAll")
	 public ResponseEntity<List<CompanyBasicDetails>> getAllComapny(){
		 List<CompanyBasicDetails> allcompany = companyBasicDetailsService.getAllcompany();
		 return new ResponseEntity<List<CompanyBasicDetails>>(allcompany, HttpStatus.OK);
	 }
	 
	 @GetMapping("/byname/{companyName}")
	    public ResponseEntity<List<CompanyBasicDetails>> getCompanyByName(@PathVariable String companyName) {
	        List<CompanyBasicDetails> companyOptional = companyBasicDetailsService.getCompanyByName(companyName);
	        if (companyOptional!=null) {
	            return new ResponseEntity<List<CompanyBasicDetails>>(companyOptional,HttpStatus.OK);
	        } else {
	        	throw new CompanyNameNotFoundException("company is not found with name "+ companyName);
	        }
	 }

	 @GetMapping("/paging")
	 public ResponseEntity<List<CompanyBasicDetails>> getCompaniespaging(
			 @RequestParam(value = "pageNumber", defaultValue = "1" ,required = false) Integer pageNumber,
			 @RequestParam(value = "pageSize", defaultValue = "5" , required = false) Integer pageSize
			 ){
	List<CompanyBasicDetails> basicComp	= this.companyBasicDetailsService.gellAllCompaniesPaging(pageNumber, pageSize);
	return new ResponseEntity<List<CompanyBasicDetails>>(basicComp, HttpStatus.OK);
	
	 }
}
	

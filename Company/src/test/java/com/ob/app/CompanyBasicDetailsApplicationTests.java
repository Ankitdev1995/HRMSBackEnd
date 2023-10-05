package com.ob.app;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ob.app.company.controller.CompanyBasicDetailsController;
import com.ob.app.company.entity.CompanyBasicDetails;
import com.ob.app.company.exception.CompanyNameNotFoundException;

@SpringBootTest
class CompanyBasicDetailsApplicationTests {

	@Autowired
	private CompanyBasicDetailsController companyBasicDetailsController;


	@Test
	void contextLoads() 
	{

	}

	@Test
	void saveDetailsTest() {
		CompanyBasicDetails companyBasicDetails = new CompanyBasicDetails();
		companyBasicDetails.setAbbrivation("qwwe");
		companyBasicDetails.setCompanyName("XYZ");
		companyBasicDetails.setDateOfIncorporation(new Date());
		companyBasicDetails.setWebsite("www.org.com");

		ResponseEntity<CompanyBasicDetails> response =	companyBasicDetailsController.saveDetails(companyBasicDetails);

		assertNotNull(response);
	}	


	@Test
	public void GetAllCompanyTest() {

		List<CompanyBasicDetails> companyList = new ArrayList<>();
		CompanyBasicDetails company1 = new CompanyBasicDetails();
		company1.setCompanyName("TestCompany1");
		company1.setDateOfIncorporation(new Date());
		company1.setWebsite("www.ob.com");
		company1.setAbbrivation("nxy");
		
		
		CompanyBasicDetails company2 = new CompanyBasicDetails();
		company2.setCompanyName("TestCompany2");
		company2.setDateOfIncorporation(new Date());
		company2.setWebsite("www.ofb.com");
		company2.setAbbrivation("nty");
		

		companyList.add(company1);
		companyList.add(company2);


		ResponseEntity<List<CompanyBasicDetails>> response = companyBasicDetailsController.getAllComapny();

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(7, response.getBody().size());
		assertEquals("infosys", response.getBody().get(0).getCompanyName());
		assertEquals("XYZ", response.getBody().get(2).getCompanyName());
	}
	
	
	    @Test
	    public void GetCompanyByIdTest() {
	        
	        CompanyBasicDetails company = new CompanyBasicDetails();
	        company.setCompanyId(1);
	        company.setCompanyName("TestCompany");
	       	       
	        ResponseEntity<CompanyBasicDetails> response = companyBasicDetailsController.getCompanyById(2);
	        
	        assertEquals(HttpStatus.OK, response.getStatusCode());
	        assertNotNull(response.getBody());
	        assertEquals("infosys", response.getBody().getCompanyName());
	    }

	    @Test
	    public void GetCompanyByIdNotFoundTest() {
	        
	        CompanyNameNotFoundException exception = assertThrows(CompanyNameNotFoundException.class, ()-> {
	        	companyBasicDetailsController.getCompanyById(5525);
	        });
	        assertEquals("company is not found with id: 5525", exception.getMessage());
	    }
	    }	

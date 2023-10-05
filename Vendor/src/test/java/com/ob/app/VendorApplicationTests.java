package com.ob.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ob.app.vendor.controller.VendorDetailsController;
import com.ob.app.vendor.entity.VendorDetails;
import com.ob.app.vendor.exception.LocationNotFoundException;

@SpringBootTest
class VendorApplicationTests {

	@Autowired
	VendorDetailsController vendorDetailsController;

	@Test
	void contextLoads() {
	}

	@Test
	void savePartnerDetailsTest() {
		VendorDetails vendorDetails = new VendorDetails();
		vendorDetails.setVendorName("Accenture");
		
		ResponseEntity<String> response  = vendorDetailsController.saveVendorDetails(vendorDetails);
		assertNotNull(response);
	}
	
	@Test
	void getCompanyByNameTest() {
	    
        VendorDetails partner = new VendorDetails();
      
        partner.setVendorName("Reliance");
        ResponseEntity<VendorDetails> response = vendorDetailsController.getCompanyByName("Reliance");

       
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Reliance", response.getBody().getVendorName());
    }

    @Test
    public void GetCompanyByNameNotFoundTest() {
      
        LocationNotFoundException exception = assertThrows(LocationNotFoundException.class, () -> {
        	vendorDetailsController.getCompanyByName("Infosyshh");
        });
        assertEquals("location is not found with company name", exception.getMessage()); 
	}
}

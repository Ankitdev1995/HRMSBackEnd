package com.ob.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ob.app.partner.controller.PartnerDetailsController;
import com.ob.app.partner.entity.PartnerDetails;
import com.ob.app.partner.exception.LocationNotFoundException;

@SpringBootTest
class PartnerApplicationTests {

	@Autowired
	PartnerDetailsController partnerDetailsController;

	@Test
	void contextLoads() {
	}

	@Test
	void savePartnerDetailsTest() {
		PartnerDetails partnerDetails = new PartnerDetails();
		partnerDetails.setPartnerName("Accenture");
		
		ResponseEntity<String> response  = partnerDetailsController.savePartnerDetails(partnerDetails);
		assertNotNull(response);
	}
	
	@Test
	void getCompanyByNameTest() {
	    
        PartnerDetails partner = new PartnerDetails();
      
        partner.setPartnerName("Reliance");
        ResponseEntity<PartnerDetails> response = partnerDetailsController.getCompanyByName("Reliance");

       
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Reliance", response.getBody().getPartnerName());
    }

    @Test
    public void GetCompanyByNameNotFoundTest() {
      
        LocationNotFoundException exception = assertThrows(LocationNotFoundException.class, () -> {
        	partnerDetailsController.getCompanyByName("Infosyshh");
        });
        assertEquals("location is not found with company name", exception.getMessage()); 
	}
}

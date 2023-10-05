package com.ob.app.partner.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ob.app.vendor.controller.LocationController;
import com.ob.app.vendor.entity.Location;
import com.ob.app.vendor.repository.LocationRepository;
import com.ob.app.vendor.serviceImpl.LocationServiceImpl;

@SpringBootTest
public class LocationControllerTest {

	@Autowired
	private LocationController locationController;
	
	@Mock
	LocationRepository locationRepository;

	@InjectMocks
	LocationServiceImpl locationServiceImpl;
	
	@Test
	void saveLocationTest() {
		Location location = new Location();

		location.setLocationId(1);
		location.setAddressLine1("bardi");
		location.setAddressLine2("plot no 5");
		location.setCity("mumbai");
		location.setRegion("west");
		location.setState("maharashtra");
		location.setPin("9087458902");
		location.setCountry("India");

		ResponseEntity<Location> response = locationController.saveLocation(location);
		assertNotNull(response);
		assertEquals(HttpStatus.CREATED, response.getStatusCode());      
	}

	    @Test
	    public void testAllLocationWithValidData() {   
	        List<Location> validLocationList = new ArrayList<>();
	        
	        validLocationList.add(new Location(1, "azml", "ertt", "sfgh", "east", "Japan", "HUWAYE", "433454545"));
	        validLocationList.add(new Location(2, "dfl", "fdtt", "sfgh", "west", "germany", "HUWAYE", "454545"));
	    
	        when(locationRepository.findAll()).thenReturn(validLocationList);
   
	      //  assertEquals(HttpStatus.OK, response.getStatusCode());
	      //  assertEquals(validLocationList, response.getBody());
	          assertEquals(2, locationServiceImpl.getAllLocation().size());
	    }

//	    @Test
//	    public void testAllLocationWithEmptyList() {
//	        
//	        List<Location> emptyLocationList = new ArrayList<>();
//	        when(locationService.getAllLocation()).thenReturn(emptyLocationList);
//
//	        
//	        ResponseEntity<List<Location>> response = locationController.AllLocation();
//
//	        
//	        assertEquals(HttpStatus.OK, response.getStatusCode());
//	        assertEquals(emptyLocationList, response.getBody());
//	    }
//
//	    @Test
//	    public void testAllLocationWithServiceFailure() {
//	        
//	        when(locationService.getAllLocation()).thenReturn(null); 
//
//	        
//	        ResponseEntity<List<Location>> response = locationController.AllLocation();
//
//	        
//	        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
//	        assertNull(response.getBody());
//	    }
//	}

	}


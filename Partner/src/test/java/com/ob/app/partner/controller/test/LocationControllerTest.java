package com.ob.app.partner.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ob.app.partner.controller.LocationController;
import com.ob.app.partner.entity.Location;

@SpringBootTest
class LocationControllerTest {
	
	@Autowired
	private	LocationController locationController;
		
	
		@Test
		void saveLocationTest() {
			Location location = new Location();
			location.setLocationId(1);
			location.setAddressLine1("trimutri nagar");
			location.setAddressLine2("plot no 10");
			location.setCity("Nagpur");
			location.setPin("447890");
			location.setRegion("East");
			location.setState("maharashtra");
			location.setCountry("India");
			ResponseEntity<Location> response = locationController.saveLocation(location);
			
			assertNotNull(response);
			assertEquals(HttpStatus.CREATED, response.getStatusCode());
		}
	
	@Test	
	void AllLocationTest(){
		List<Location> loclist1 = new ArrayList<>();
		Location location1 = new Location();
		location1.setLocationId(1);
		location1.setAddressLine1("trimutri nagar");
		location1.setAddressLine2("plot no 10");
		location1.setCity("Nagpur");
		location1.setPin("447890");
		location1.setRegion("East");
		location1.setState("maharashtra");
		location1.setCountry("India");
		
		List<Location> loclist2 = new ArrayList<>();
		Location location2 = new Location();
		location2.setLocationId(1);
		location2.setAddressLine1("trimutri nagar");
		location2.setAddressLine2("plot no 10");
		location2.setCity("Nagpur");
		location2.setPin("447890");
		location2.setRegion("East");
		location2.setState("maharashtra");
		location2.setCountry("India");
		
		loclist1.add(location1);
		loclist2.add(location2);
		
		ResponseEntity<List<Location>> response = locationController.AllLocation();
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertNotNull(response.getBody());
		assertEquals(1, response.getBody().get(0).getLocationId());
		assertEquals("India", response.getBody().get(1).getCountry());
	}
}
package com.ob.app.partner.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ob.app.partner.controller.PointOfContactController;
import com.ob.app.partner.entity.PointOfContact;
import com.ob.app.partner.repository.PointOfContactRepository;
import com.ob.app.partner.serviceImpl.PointOfContactServiceImpl;

@SpringBootTest(classes = PointOfContactControllerTest.class)
public class PointOfContactControllerTest {
	
	@Mock
	private PointOfContactController pointOfContactController;
	
	@Mock
	PointOfContactRepository pointOfContactRepository;
	
	@InjectMocks
	PointOfContactServiceImpl pointOfContactServiceImpl;
	
	@Test
	public void test_getPointOfContact() {
		List<PointOfContact> listcontact = new ArrayList<>();
	
	listcontact.add(new PointOfContact(1, "swigy",  9056474856l, "vs@gmail.com"));
	listcontact.add(new PointOfContact(2, "zomato", 8956467856l, "vz@gmail.com"));
	listcontact.add(new PointOfContact(3, "amazon", 4956467856l, "va@gmail.com"));
	
	when(pointOfContactRepository.findAll()).thenReturn(listcontact);
	assertEquals(3, pointOfContactServiceImpl.getAllPointOfContact().size());
	}
	
	@Test
	public void test_getpointByCompanyName(){
		List<PointOfContact> listpoint = new ArrayList<PointOfContact>();
		
		listpoint.add(new PointOfContact(1, "swigy",  9056474856l, "vs@gmail.com"));
		listpoint.add(new PointOfContact(2, "zomato", 8956467856l, "vz@gmail.com"));
	
		String companyName = "Insurance";
		
		when(pointOfContactRepository.findAll()).thenReturn(listpoint);
		
		assertEquals(companyName, pointOfContactServiceImpl.getPointOfContactCompanyName(companyName));
		
	}
}

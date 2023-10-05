package com.ob.app.partner.controller.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ob.app.vendor.entity.PointOfContact;
import com.ob.app.vendor.repository.PointOfContactRepository;
import com.ob.app.vendor.serviceImpl.PointOfContactServiceImpl;

@SpringBootTest
public class PointOfContactControllerTest {
	
	@Mock
	PointOfContactRepository pointOfContactRepository;
	
	@InjectMocks
	PointOfContactServiceImpl pointOfContactServiceImpl;
	
	@Test
	public void testgetPointOfContact() {
		
		List<PointOfContact> pointOfContact = new ArrayList<>();
		pointOfContact.add(new PointOfContact(1, "XYZ", 9856473728l, "xyz@gmail.com", null));
		pointOfContact.add(new PointOfContact(2, "PQR", 8078473728l, "pqr@gmail.com", null));
	
		when(pointOfContactRepository.findAll()).thenReturn(pointOfContact);
		
		assertEquals(2, pointOfContactServiceImpl.getAllPointOfContact().size());
	}
}

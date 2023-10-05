package com.ob.app.vendor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ob.app.vendor.entity.PointOfContact;
import com.ob.app.vendor.service.PointOfContactService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/vendor")
public class PointOfContactController {

	@Autowired
	private PointOfContactService  pointOfContactService;

	@PostMapping("/pointsave")
	public ResponseEntity<PointOfContact> savedPointOfContact(@Valid @RequestBody PointOfContact pointOfContact){
		PointOfContact savedPointOfContact = pointOfContactService.savePointOfContact(pointOfContact);
		return new ResponseEntity<PointOfContact>(savedPointOfContact, HttpStatus.CREATED);
	}

	@PutMapping("/updatepoint/{pointOfContactId}")
	public ResponseEntity<String> updatePointOfContact(@RequestBody PointOfContact pointOfContact, @PathVariable int pointOfContactId){
		PointOfContact updatedpointofcontact = 	pointOfContactService.updatePointOfContact(pointOfContact, pointOfContactId);
		if(updatedpointofcontact!=null) {
			return new ResponseEntity<String>("point of contact is updated with id:"+ pointOfContactId, HttpStatus.OK);
		}else {
			return new ResponseEntity(updatedpointofcontact, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/getAllpoint")
	public ResponseEntity<List<PointOfContact>> getPointOfContact(){
		List<PointOfContact> getAllPoint = pointOfContactService.getAllPointOfContact();
		return new ResponseEntity<List<PointOfContact>>(getAllPoint, HttpStatus.OK);
	}

	
	@DeleteMapping("/deletePoint/{pointOfContactId}")
	public ResponseEntity<String> deleteContact(@PathVariable int pointOfContactId) {
		boolean deleted = pointOfContactService.deletePointOfContact(pointOfContactId);
		if (deleted) {
			return new ResponseEntity<>("Point of contact is deleted with id:"+ pointOfContactId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Point of contact not found with id:" + pointOfContactId, HttpStatus.NOT_FOUND);
		}
	}


	@GetMapping("/pname/{companyName}")
	public ResponseEntity<String> getpointByCompanyName(@PathVariable String companyName){
		List<PointOfContact>  listname = pointOfContactService.getPointOfContactCompanyName(companyName);
		if(!listname.isEmpty()) {
			return new ResponseEntity(listname, HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("name is not found with given point of contact : "+ companyName, HttpStatus.NOT_FOUND);		
		}
	}
}



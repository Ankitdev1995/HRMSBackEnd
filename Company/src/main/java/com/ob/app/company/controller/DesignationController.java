package com.ob.app.company.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ob.app.company.entity.Designation;
import com.ob.app.company.exception.DesignationNotFoundException;
import com.ob.app.company.services.DesignationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class DesignationController {
	
	@Autowired
	private DesignationService designationService;
	
	@PostMapping("/savedes")
	public ResponseEntity<Designation> saveDesignation(@Valid @RequestBody Designation designation){
		Designation saveDesignation = designationService.saveDesignation(designation);
		return new ResponseEntity<Designation>(saveDesignation, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{designationId}")
	public ResponseEntity<String> deleteDesignation(@PathVariable int designationId){
		String designationDelete = designationService.deleteDesignation(designationId);
		return new ResponseEntity<String>(designationDelete, HttpStatus.OK);
	}
	
	@GetMapping("/getDesig")
	public ResponseEntity<List<Designation>> getAllDesignation(){
		List<Designation> getAllDes = designationService.getAllDesignation();
		return new ResponseEntity<List<Designation>>(getAllDes, HttpStatus.OK);
	}
	
	@GetMapping("/name/{groupName}")
	public ResponseEntity<List<Designation>> searchDesignationByGroupName(@PathVariable String groupName){
		List<Designation> designationByGroupName = designationService.getDesignationByGroupName(groupName);
		if(!designationByGroupName.isEmpty()) {
			return new ResponseEntity<List<Designation>>(designationByGroupName, HttpStatus.OK);
		}else {
			throw new DesignationNotFoundException("designation not found with group name : "+ groupName);
		}
	}
		
		@GetMapping("/id/{designationId}")
		public ResponseEntity<Designation> getDesignationById(@PathVariable int designationId){
			Optional<Designation> designationById = designationService.getDesignationById(designationId);
			if(designationById.isPresent()) {
				return new ResponseEntity (designationById, HttpStatus.OK);
			}else {
				throw new DesignationNotFoundException("designation is not found with id : " + designationId);
			}
		}
	}


package com.ob.app.company.controller;

import java.util.List;

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

import com.ob.app.company.entity.DesignationGroup;
import com.ob.app.company.services.DesignationGroupService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class DesignationGroupController {

	@Autowired
	private DesignationGroupService designationGroupService;

	@PostMapping("/desg")
	public ResponseEntity<DesignationGroup> savedesignationGroup(@Valid @RequestBody DesignationGroup designationGroup){
		DesignationGroup saved = designationGroupService.saveDesignationGroup(designationGroup);
		return new ResponseEntity<DesignationGroup>(saved, HttpStatus.OK);		
	}

	@DeleteMapping("/delete/{designationGroupId}")
	public ResponseEntity<String>deleteDesignationGroup(@PathVariable int designationGroupId){
		String deletedesignationGroup = designationGroupService.deleteDesignationGroup(designationGroupId);
		return new ResponseEntity<String>(deletedesignationGroup, HttpStatus.OK);
	}
	
	@GetMapping("/getGroup")
	public ResponseEntity<List<DesignationGroup>> getAllDesigGroup(){
		List<DesignationGroup> list = designationGroupService.getAllDesginationGroup();
		if(!list.isEmpty()) {
			return new ResponseEntity<List<DesignationGroup>>(list, HttpStatus.OK);
		}else {
			return new ResponseEntity<List<DesignationGroup>>(list, HttpStatus.NOT_FOUND);
		}
	}
}

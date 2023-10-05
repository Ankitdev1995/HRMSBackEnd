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

import com.ob.app.company.entity.Department;
import com.ob.app.company.services.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/company")
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService ;

	
	@PostMapping("/newdept")
	public ResponseEntity<Department> saveDepartments(@Valid @RequestBody Department department){
		Department  departmentSaved =  departmentService.saveDepartment(department);
		return new ResponseEntity<Department>(departmentSaved, HttpStatus.OK);
	}

	@DeleteMapping("/dlt/{departmentId}")
	public ResponseEntity<String> deleteDepartment(@PathVariable int departmentId){
		String deleteEmployee = departmentService.deleteDepartment(departmentId);
		return new ResponseEntity<String>(deleteEmployee, HttpStatus.OK);
	}

	@GetMapping("/getDept")
	public ResponseEntity<List<Department>> getAllDepartment(){
		List<Department> allDepartment = departmentService.getAllDepartment();
		return new ResponseEntity<List<Department>>(allDepartment, HttpStatus.OK);
	}

	@GetMapping("/dept/{departmentId}")
	public ResponseEntity<Department> getDeptById(@PathVariable int departmentId){
		Optional<Department> departmentById = departmentService.getDepartmentById(departmentId);

		if(departmentById.isPresent()) {
			return new ResponseEntity<> (departmentById.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity("department is not found with given id : " + departmentId, HttpStatus.NOT_FOUND);
		}
	}
}



package com.ob.app.company.services;

import java.util.List;
import java.util.Optional;

import com.ob.app.company.entity.Department;

public interface DepartmentService {
	
	public Department saveDepartment(Department department);
	
	public String deleteDepartment(Integer departmentId);
	
	public List<Department> getAllDepartment();
	
	public Optional<Department> getDepartmentById(int departmentId);
	
  }

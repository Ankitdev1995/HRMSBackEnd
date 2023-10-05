package com.ob.app.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ob.app.company.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{
	
	
}

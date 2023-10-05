package com.ob.app.company.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ob.app.company.entity.Department;
import com.ob.app.company.repository.DepartmentRepository;
import com.ob.app.company.services.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		Department saveDept = departmentRepository.save(department);
		return saveDept;
	}

	@Override
	public String deleteDepartment(Integer departmentId) {
		departmentRepository.deleteById(departmentId);
		return "Department is deleted";
	}

	@Override
	public List<Department> getAllDepartment() {
		List<Department> deptList = departmentRepository.findAll();
		return deptList;
	}

	@Override
	public Optional<Department> getDepartmentById(int departmentId) {
		return departmentRepository.findById(departmentId);

	}
}


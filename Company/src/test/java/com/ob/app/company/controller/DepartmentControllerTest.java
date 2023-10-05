package com.ob.app.company.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.ob.app.company.entity.Department;


@SpringBootTest
class DepartmentControllerTest {
	
	@Autowired
	private DepartmentController departmentController;

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	void saveDepartmentsTest() {
		
		Department department = new Department();
	
		department.setDepartmentName("HR");
		department.setDescription("this is HR department");
		
	 ResponseEntity<Department> responses = departmentController.saveDepartments(department);
	 assertNotNull(responses);
	}
	
    @Test
    public void DeleteDepartmentTest() {
        ResponseEntity<String> response = departmentController.deleteDepartment(2);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Department is deleted", response.getBody());
    }

    @Test
    public void DeleteDepartmentNotFoundTest() {
        ResponseEntity<String> response = departmentController.deleteDepartment(2);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("Department not found", response.getBody());
    }
    
    @Test
    public void getAllDepartmentTest() {
    	List<Department> deptList1 = new ArrayList<>();
    	Department department1 = new Department();
    	department1.setDepartmentName("HR");
    	department1.setDescription("XVB");
    	
    	List<Department> deptList2 = new ArrayList<>();
    	Department department2 = new Department();
    	department2.setDepartmentName("SALES");
    	department2.setDescription("XBN");
    	
    	deptList1.add(department1);
    	deptList2.add(department2);
    	
    	ResponseEntity<List<Department>> response = departmentController.getAllDepartment();
    	
    	assertEquals(HttpStatus.OK, response.getStatusCode());
    	assertNotNull(response.getBody());
    	assertEquals("HR", response.getBody().get(0).getDepartmentName());
    	assertEquals("SALES", response.getBody().get(1).getDepartmentName());
    }
}


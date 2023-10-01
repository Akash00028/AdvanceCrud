package com.akash00028.advancedCrud.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akash00028.advancedCrud.models.Department;
import com.akash00028.advancedCrud.service.DepartmentService;

@RestController
@RequestMapping("/employees")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;

	
	@PostMapping("/department")
	public ResponseEntity<Department> save(@RequestBody Department department) {
		return departmentService.save(department);
	}

	
	@GetMapping("/department")
	public ResponseEntity<List<Department>> getSalaries() {
		return departmentService.findAll();
	}

	
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getSalaryById(@PathVariable Long id) {
		return departmentService.findById(id);
	}

	
	@PutMapping("/department/{id}")
	public Department updateDepartment(@PathVariable Long id, @RequestBody Department department) {
		return departmentService.update(id, department);
	}

	
	@DeleteMapping("/department/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
		return departmentService.delete(id);
	}
}

package com.akash00028.advancedCrud.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akash00028.advancedCrud.Exception.ResourceNotFoundException;
import com.akash00028.advancedCrud.models.Department;
import com.akash00028.advancedCrud.models.Employee;
import com.akash00028.advancedCrud.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public ResponseEntity<Department> save(Department department) {
		departmentRepository.save(department);
		return ResponseEntity.ok(department);
	}
	
	
	
	public ResponseEntity<List<Department>> findAll() {
		List<Department> departments = departmentRepository.findAll();
		return ResponseEntity.ok(departments);
	}

	public ResponseEntity<Department> findById(Long id) {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department with " + id + " not found"));

		return ResponseEntity.ok(department);
	}

	public Department update(Long id, Department departmentDetails) {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department with " + id + " not found"));
		department.setId(departmentDetails.getId());
		department.setName(departmentDetails.getName());
		department.setJobRole(departmentDetails.getJobRole());
		return department;
		
	}

	public ResponseEntity<Map<String, Boolean>> delete(Long id) {
		Department department = departmentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Department with " + id + " not found"));
		departmentRepository.delete(department);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

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

import com.akash00028.advancedCrud.models.Employee;
import com.akash00028.advancedCrud.service.EmployeeService;

@RestController
@RequestMapping("")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	
	@PostMapping("/employees")
	public ResponseEntity<Employee> save(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		return employeeService.findAll();
	}

	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		return employeeService.getById(id);
	}

	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
		return employeeService.update(id, employeeDetails);
	}

	
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable Long id) {
		return employeeService.delete(id);
	}
}

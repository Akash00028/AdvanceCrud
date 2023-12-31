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

import com.akash00028.advancedCrud.models.Salary;
import com.akash00028.advancedCrud.service.SalaryService;

@RestController
@RequestMapping("employees")
public class SalaryController {
	@Autowired
	private SalaryService salaryService;

	
	@PostMapping("/salary")
	public ResponseEntity<Salary> save(@RequestBody Salary salary) {
		return salaryService.save(salary);
	}

	
	@GetMapping("salary")
	public ResponseEntity<List<Salary>> getSalary() {
		return salaryService.findAll();
	}

	
	@GetMapping("salary/{id}")
	public ResponseEntity<Salary> getSalaryById(@PathVariable Long id) {
		return salaryService.findById(id);
	}

	
	@PutMapping("salary/{id}/{newSalary}")
	public ResponseEntity<Salary> updateSalary(@PathVariable Long id, @PathVariable double newSalary) {
		return salaryService.update(id, newSalary);
	}

	
	@DeleteMapping("salary/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
		return salaryService.delete(id);
	}
}

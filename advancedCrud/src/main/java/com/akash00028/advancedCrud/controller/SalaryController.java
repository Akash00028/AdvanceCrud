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
@RequestMapping("/api/v1/employees")
@CrossOrigin(origins = "http://localhost:4200")
public class SalaryController {
	@Autowired
	private SalaryService salaryService;

	/**
	 * http://localhost:9090/api/v1/employees/salary
	 * 
	 * @param salary
	 * @return
	 */
	@PostMapping("/salary")
	public ResponseEntity<Salary> save(@RequestBody Salary salary) {
		return salaryService.save(salary);
	}

	/**
	 * http://localhost:9090/api/v1/employees/salary
	 * 
	 * @return
	 */
	@GetMapping("salary")
	public ResponseEntity<List<Salary>> getSalary() {
		return salaryService.findAll();
	}

	/**
	 * http://localhost:9090/api/v1/employees/salary/122
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("salary/{id}")
	public ResponseEntity<Salary> getSalaryById(@PathVariable Long id) {
		return salaryService.findById(id);
	}

	/**
	 * http://localhost:9090/api/v1/employees/salary/122/12453
	 * 
	 * @param id
	 * @param amount
	 * @return
	 */
	@PutMapping("salary/{id}/{newSalary}")
	public ResponseEntity<Salary> updateSalary(@PathVariable Long id, @PathVariable double newSalary) {
		return salaryService.update(id, newSalary);
	}

	/**
	 * http://localhost:9090/api/v1/employees/salary/132
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("salary/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
		return salaryService.delete(id);
	}
}

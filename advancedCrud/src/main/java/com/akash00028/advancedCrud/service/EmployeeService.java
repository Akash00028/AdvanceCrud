package com.akash00028.advancedCrud.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.akash00028.advancedCrud.Exception.ResourceNotFoundException;
import com.akash00028.advancedCrud.models.Department;
import com.akash00028.advancedCrud.models.Employee;
import com.akash00028.advancedCrud.models.Salary;
import com.akash00028.advancedCrud.models.Skill;
import com.akash00028.advancedCrud.repository.DepartmentRepository;
import com.akash00028.advancedCrud.repository.EmployeeRepository;
import com.akash00028.advancedCrud.repository.SkillRepository;
import com.akash00028.advancedCrud.repository.salaryRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private SkillRepository skillRepository;

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private SalaryService salaryService;

	
	public ResponseEntity<Employee> save(Employee employee) {
		Skill skill = new Skill();
		List<Skill> skills = new ArrayList<>();
		for (Skill skill2 : employee.getEmployeeSkills()) {
			skill = skillRepository.findByname(skill2.getName());
					
			if (skill != null) {
				skills.add(skill);
			} else {
				skillRepository.save(skill2);
				skills.add(skill2);
			}
		}
		employee.setEmployeeSkills(skills);

		Department dep = employee.getDep();
		Department department = departmentRepository.findByNameAndJobRole(dep.getName(), dep.getJobRole());
		if (department != null) {
			employee.setDep(department);
		} else {
			departmentRepository.save(dep);
		}
		employee.getSalary().setEmployee(employee);
		employeeRepository.save(employee);
		return ResponseEntity.ok(employee);
	}

	public ResponseEntity<List<Employee>> findAll() {
		List<Employee> employees = employeeRepository.findAll();
		return ResponseEntity.ok(employees);
	}

	public ResponseEntity<Employee> getById(long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with " + id + " not found"));
		return ResponseEntity.ok(employee);
	}

	public ResponseEntity<Employee> update(Long id, Employee employeeDetails) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with " + id + " not found"));
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmail(employeeDetails.getEmail());

		Skill skill = new Skill();
		List<Skill> skills = new ArrayList<>();
		for (Skill skill2 : employeeDetails.getEmployeeSkills()) {
			skill = skillRepository.findByname(skill2.getName());
			if (skill != null) {
				skills.add(skill);
			} else {
				skillRepository.save(skill2);
				skills.add(skill2);
			}
		}
		employee.setEmployeeSkills(skills);

		Department dep = employeeDetails.getDep();
		Department department = departmentRepository.findByNameAndJobRole(dep.getName(), dep.getJobRole());
		if (department != null) {
			employee.setDep(department);
		} else {
			departmentRepository.save(dep);
		}

		Salary salary = employee.getSalary();
		System.out.println(salary.getId());
		salaryService.update(salary.getId(), employeeDetails.getSalary().getSalary());

		employeeRepository.save(employee);
		return ResponseEntity.ok(employee);
	}

	public ResponseEntity<Map<String, Boolean>> delete(Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee with " + id + " not found"));
		employeeRepository.delete(employee);

		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}

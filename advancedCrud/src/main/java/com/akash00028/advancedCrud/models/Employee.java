package com.akash00028.advancedCrud.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String firstName;
	private String lastName;

	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name="department")
	private Department dep;

	@Column(unique = true)
	private String email;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Skill> employeeSkills = new ArrayList<>();

	@OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
	private Salary salary;

	public Employee() {
	}

	public Employee(long id, String firstName, String lastName, Department dep, String email,
			List<Skill> employeeSkills, Salary salary) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dep = dep;
		this.email = email;
		this.employeeSkills = employeeSkills;
		this.salary = salary;
	}

	public Salary getSalary() {
		return salary;
	}

	public void setSalary(Salary salary) {
		this.salary = salary;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Skill> getEmployeeSkills() {
		return employeeSkills;
	}

	public void setEmployeeSkills(List<Skill> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}

}

// { "firstName": "Ravi", "lastName": "tiwari", "dep": { "name":"CS",
// "jobRole":"programmer" }, "email": "ravi@gmail.com", "employeeSkills": [ {
// "name": "Java", "proficency": "AAA"
// 
// }], "salary": { "salary":1500.00 } }
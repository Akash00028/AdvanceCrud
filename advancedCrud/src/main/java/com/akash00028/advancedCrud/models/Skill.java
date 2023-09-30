package com.akash00028.advancedCrud.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
public class Skill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String name;
	
//	private String proficency;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "employeeSkills")
	@JsonIgnore
	private List<Employee> employees = new ArrayList<>();
	
	public Skill() {

	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public String getProficency() {
//		return proficency;
//	}
//
//	public void setProficency(String proficency) {
//		this.proficency = proficency;
//	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}


/*
 	{
 		"name": "Java",
 		"proficency": "YGh",
 		
 	}
 */


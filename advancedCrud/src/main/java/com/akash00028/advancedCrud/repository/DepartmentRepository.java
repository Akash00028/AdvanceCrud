package com.akash00028.advancedCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash00028.advancedCrud.models.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
	public Department findByNameAndJobRole(String name,String jobRole);
}

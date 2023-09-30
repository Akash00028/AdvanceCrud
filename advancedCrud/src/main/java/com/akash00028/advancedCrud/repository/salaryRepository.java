package com.akash00028.advancedCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash00028.advancedCrud.models.Salary;

@Repository
public interface salaryRepository extends JpaRepository<Salary, Long> {

}

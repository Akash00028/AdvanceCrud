package com.akash00028.advancedCrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash00028.advancedCrud.models.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
	
	public Skill findByname(String name);
}

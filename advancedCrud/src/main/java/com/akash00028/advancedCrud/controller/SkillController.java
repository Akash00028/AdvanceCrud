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

import com.akash00028.advancedCrud.models.Skill;
import com.akash00028.advancedCrud.service.SkillService;


@RestController
@RequestMapping("employees/")
public class SkillController {
	@Autowired
	private SkillService skillService;

	
	@PostMapping("/skills")
	public ResponseEntity<Skill> save(@RequestBody Skill skill) {
		return skillService.save(skill);
	}

	
	@GetMapping("/skills")
	public ResponseEntity<List<Skill>> getSkills() {
		return skillService.findAll();
	}

	
	@GetMapping("/skills/{id}")
	public ResponseEntity<Skill> getSkillsById(@PathVariable Long id) {
		return skillService.findById(id);
	}

	
	@PutMapping("/skills/{id}")
	public ResponseEntity<Skill> updateSkills(@PathVariable Long id, @RequestBody Skill skill) {
		return skillService.update(id, skill);
	}

	
	@DeleteMapping("/skills/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
		return skillService.delete(id);
	}

}

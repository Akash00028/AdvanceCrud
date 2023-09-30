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
@RequestMapping("/api/v1/employees/")
@CrossOrigin(origins = "http://localhost:4200")
public class SkillController {
	@Autowired
	private SkillService skillService;

	/**
	 * http://localhost:9090/api/v1/employees/skills
	 * 
	 * @param skill
	 * @return
	 */
	@PostMapping("/skills")
	public ResponseEntity<Skill> save(@RequestBody Skill skill) {
		return skillService.save(skill);
	}

	/**
	 * http://localhost:9090/api/v1/employees/skills
	 * 
	 * @return
	 */
	@GetMapping("/skills")
	public ResponseEntity<List<Skill>> getSkills() {
		return skillService.findAll();
	}

	/**
	 * http://localhost:9090/api/v1/employees/skills/124
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/skills/{id}")
	public ResponseEntity<Skill> getSkillsById(@PathVariable Long id) {
		return skillService.findById(id);
	}

	/**
	 * http://localhost:9090/api/v1/employees/skills/123
	 * 
	 * @param id
	 * @param skill
	 * @return
	 */
	@PutMapping("/skills/{id}")
	public ResponseEntity<Skill> updateSkills(@PathVariable Long id, @RequestBody Skill skill) {
		return skillService.update(id, skill);
	}

	/**
	 * http://localhost:9090/api/v1/employees/skills/134
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/skills/{id}")
	public ResponseEntity<Map<String, Boolean>> delete(@PathVariable Long id) {
		return skillService.delete(id);
	}

}

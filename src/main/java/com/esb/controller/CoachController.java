package com.esb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import com.esb.model.Coach;
import com.esb.model.Specialty;
import com.esb.service.CoachService;

@RestController
@RequestMapping("/api/coaches")
public class CoachController {
	@Autowired
	private CoachService coachService;

	@GetMapping
	public List<Coach> getAllCoaches() {
		return coachService.getAllCoaches();
	}

	@GetMapping("/{id}")
	public Coach getCoachById(@PathVariable Long id) {
		return coachService.getCoachById(id);
	}

	@GetMapping("/specialty/{specialty}")
	public List<Coach> getCoachesBySpecialty(@PathVariable Specialty specialty) {
		return coachService.getCoachesBySpecialty(specialty);
	}

	@PostMapping
	public Coach addCoach(@Valid @RequestBody Coach coach) {
		return coachService.addCoach(coach);
	}

	@PutMapping("/{id}")
	public Coach updateCoach(@PathVariable Long id, @Valid @RequestBody Coach coachDetails) {
		return coachService.updateCoach(id, coachDetails);
	}

	@DeleteMapping("/{id}")
	public String deleteCoach(@PathVariable Long id) {
		coachService.deleteCoach(id);
		return "Coach deleted";
	}
}

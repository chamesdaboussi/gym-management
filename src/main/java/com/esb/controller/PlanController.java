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

import com.esb.model.Plan;
import com.esb.service.PlanService;

@RestController
@RequestMapping("/api/plans")
public class PlanController {
	@Autowired
	private PlanService planService;

	@GetMapping
	public List<Plan> getAllPlans() {
		return planService.getAllPlans();
	}

	@GetMapping("/{id}")
	public Plan getPlanById(@PathVariable Long id) {
		return planService.getPlanById(id);
	}

	@PostMapping
	public Plan addPlan(@Valid @RequestBody Plan plan) {
		return planService.addPlan(plan);
	}

	@PutMapping("/{id}")
	public Plan updatePlan(@PathVariable Long id, @Valid @RequestBody Plan planDetails) {
		return planService.updatePlan(id, planDetails);
	}

	@DeleteMapping("/{id}")
	public String deletePlan(@PathVariable Long id) {
		planService.deletePlan(id);
		return "Plan deleted";
	}
}

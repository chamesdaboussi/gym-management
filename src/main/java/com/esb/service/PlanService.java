package com.esb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esb.model.Plan;
import com.esb.repository.PlanRepository;

@Service
public class PlanService {
	@Autowired
	private PlanRepository planRepository;

	public List<Plan> getAllPlans() {
		return planRepository.findAll();
	}

	public Plan getPlanById(Long id) {
		return planRepository.findById(id).orElseThrow(() -> new RuntimeException("Plan not found"));
	}

	public Plan addPlan(Plan plan) {
		return planRepository.save(plan);
	}

	public Plan updatePlan(Long id, Plan planDetails) {
		Plan plan = getPlanById(id);
		plan.setName(planDetails.getName());
		plan.setPrice(planDetails.getPrice());
		plan.setDurationInDays(planDetails.getDurationInDays());
		return planRepository.save(plan);
	}

	public void deletePlan(Long id) {
		Plan plan = getPlanById(id);
		planRepository.delete(plan);
	}
}

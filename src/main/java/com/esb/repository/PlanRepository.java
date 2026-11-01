package com.esb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esb.model.Plan;

public interface PlanRepository extends JpaRepository<Plan, Long> {

}

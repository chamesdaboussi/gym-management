package com.esb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esb.model.Coach;
import com.esb.model.Specialty;
import com.esb.repository.CoachRepository;

@Service
public class CoachService {
	@Autowired
	private CoachRepository coachRepository;

	public List<Coach> getAllCoaches() {
		return coachRepository.findAll();
	}

	public Coach getCoachById(Long id) {
		return coachRepository.findById(id).orElseThrow(() -> new RuntimeException("Coach not found"));
	}

	public List<Coach> getCoachesBySpecialty(Specialty specialty) {
		return coachRepository.findBySpecialty(specialty);
	}

	public Coach addCoach(Coach coach) {
		return coachRepository.save(coach);
	}

	public Coach updateCoach(Long id, Coach coachDetails) {
		Coach coach = getCoachById(id);
		coach.setFullName(coachDetails.getFullName());
		coach.setPhone(coachDetails.getPhone());
		coach.setSpecialty(coachDetails.getSpecialty());
		return coachRepository.save(coach);
	}

	public void deleteCoach(Long id) {
		Coach coach = getCoachById(id);
		coachRepository.delete(coach);
	}
}

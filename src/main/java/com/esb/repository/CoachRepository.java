package com.esb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esb.model.Coach;
import com.esb.model.Specialty;

public interface CoachRepository extends JpaRepository<Coach, Long> {
	List<Coach> findBySpecialty(Specialty specialty);
}

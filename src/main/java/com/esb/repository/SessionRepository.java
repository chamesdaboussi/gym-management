package com.esb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esb.model.Session;

public interface SessionRepository extends JpaRepository<Session, Long> {
	List<Session> findByCoachId(Long coachId);
}

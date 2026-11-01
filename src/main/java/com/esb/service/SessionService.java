package com.esb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esb.model.Coach;
import com.esb.model.Session;
import com.esb.repository.SessionRepository;

@Service
public class SessionService {
	@Autowired
	private SessionRepository sessionRepository;

	@Autowired
	private CoachService coachService;

	public List<Session> getAllSessions() {
		return sessionRepository.findAll();
	}

	public Session getSessionById(Long id) {
		return sessionRepository.findById(id).orElseThrow(() -> new RuntimeException("Session not found"));
	}

	public List<Session> getSessionsByCoach(Long coachId) {
		return sessionRepository.findByCoachId(coachId);
	}

	public Session addSession(Long coachId, Session session) {
		Coach coach = coachService.getCoachById(coachId);
		session.setCoach(coach);
		return sessionRepository.save(session);
	}

	public Session updateSession(Long id, Session sessionDetails) {
		Session session = getSessionById(id);
		session.setTitle(sessionDetails.getTitle());
		session.setDate(sessionDetails.getDate());
		session.setCapacity(sessionDetails.getCapacity());
		return sessionRepository.save(session);
	}

	public void deleteSession(Long id) {
		Session session = getSessionById(id);
		sessionRepository.delete(session);
	}
}

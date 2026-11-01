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

import com.esb.model.Session;
import com.esb.service.SessionService;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {
	@Autowired
	private SessionService sessionService;

	@GetMapping
	public List<Session> getAllSessions() {
		return sessionService.getAllSessions();
	}

	@GetMapping("/{id}")
	public Session getSessionById(@PathVariable Long id) {
		return sessionService.getSessionById(id);
	}

	@GetMapping("/coach/{coachId}")
	public List<Session> getSessionsByCoach(@PathVariable Long coachId) {
		return sessionService.getSessionsByCoach(coachId);
	}

	@PostMapping("/coach/{coachId}")
	public Session addSession(@PathVariable Long coachId, @Valid @RequestBody Session session) {
		return sessionService.addSession(coachId, session);
	}

	@PutMapping("/{id}")
	public Session updateSession(@PathVariable Long id, @Valid @RequestBody Session sessionDetails) {
		return sessionService.updateSession(id, sessionDetails);
	}

	@DeleteMapping("/{id}")
	public String deleteSession(@PathVariable Long id) {
		sessionService.deleteSession(id);
		return "Session deleted";
	}
}

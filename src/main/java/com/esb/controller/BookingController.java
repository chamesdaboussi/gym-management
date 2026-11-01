package com.esb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esb.model.Booking;
import com.esb.model.Session;
import com.esb.service.BookingService;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	@Autowired
	private BookingService bookingService;

	@GetMapping
	public List<Booking> getAllBookings() {
		return bookingService.getAllBookings();
	}

	@GetMapping("/{id}")
	public Booking getBookingById(@PathVariable Long id) {
		return bookingService.getBookingById(id);
	}

	@GetMapping("/member/{memberId}/sessions")
	public List<Session> getSessionsOfMember(@PathVariable Long memberId) {
		return bookingService.getSessionsOfMember(memberId);
	}

	@PostMapping("/{memberId}/{sessionId}")
	public Booking addBooking(@PathVariable Long memberId, @PathVariable Long sessionId) {
		return bookingService.addBooking(memberId, sessionId);
	}

	@DeleteMapping("/{id}")
	public String deleteBooking(@PathVariable Long id) {
		bookingService.deleteBooking(id);
		return "Booking deleted";
	}
}

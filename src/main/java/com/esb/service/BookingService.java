package com.esb.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esb.model.Booking;
import com.esb.model.Member;
import com.esb.model.Session;
import com.esb.repository.BookingRepository;

@Service
public class BookingService {
	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private MemberService memberService;

	@Autowired
	private SessionService sessionService;

	public List<Booking> getAllBookings() {
		return bookingRepository.findAll();
	}

	public Booking getBookingById(Long id) {
		return bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
	}

	public List<Session> getSessionsOfMember(Long memberId) {
		return bookingRepository.findSessionsOfMember(memberId);
	}

	public Booking addBooking(Long memberId, Long sessionId) {
		Member member = memberService.getMemberById(memberId);
		Session session = sessionService.getSessionById(sessionId);

		if (bookingRepository.existsByMemberIdAndSessionId(memberId, sessionId)) {
			throw new RuntimeException("Member already booked this session");
		}

		if (bookingRepository.countBySessionId(sessionId) >= session.getCapacity()) {
			throw new RuntimeException("Session is full");
		}

		Booking booking = new Booking();
		booking.setMember(member);
		booking.setSession(session);
		booking.setBookingDate(LocalDate.now());

		return bookingRepository.save(booking);
	}

	public void deleteBooking(Long id) {
		Booking booking = getBookingById(id);
		bookingRepository.delete(booking);
	}
}

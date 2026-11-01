package com.esb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.esb.model.Booking;
import com.esb.model.Session;

public interface BookingRepository extends JpaRepository<Booking, Long> {
	int countBySessionId(Long sessionId);

	boolean existsByMemberIdAndSessionId(Long memberId, Long sessionId);

	@Query("SELECT b.session FROM Booking b WHERE b.member.id = :memberId")
	List<Session> findSessionsOfMember(@Param("memberId") Long memberId);
}

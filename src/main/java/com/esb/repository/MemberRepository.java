package com.esb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esb.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {

}

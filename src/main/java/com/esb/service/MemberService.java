package com.esb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esb.model.Member;
import com.esb.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	private MemberRepository memberRepository;

	public List<Member> getAllMembers() {
		return memberRepository.findAll();
	}

	public Member getMemberById(Long id) {
		return memberRepository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
	}

	public Member addMember(Member member) {
		return memberRepository.save(member);
	}

	public Member updateMember(Long id, Member memberDetails) {
		Member member = getMemberById(id);
		member.setFullName(memberDetails.getFullName());
		member.setAge(memberDetails.getAge());
		member.setEmail(memberDetails.getEmail());
		member.setPhone(memberDetails.getPhone());
		return memberRepository.save(member);
	}

	public void deleteMember(Long id) {
		Member member = getMemberById(id);
		memberRepository.delete(member);
	}
}

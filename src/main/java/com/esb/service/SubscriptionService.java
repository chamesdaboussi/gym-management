package com.esb.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esb.model.Member;
import com.esb.model.Plan;
import com.esb.model.Subscription;
import com.esb.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private MemberService memberService;

	@Autowired
	private PlanService planService;

	public List<Subscription> getAllSubscriptions() {
		return subscriptionRepository.findAll();
	}

	public Subscription getSubscriptionById(Long id) {
		return subscriptionRepository.findById(id).orElseThrow(() -> new RuntimeException("Subscription not found"));
	}

	public List<Subscription> getExpiredSubscriptions() {
		return subscriptionRepository.findExpiredSubscriptions(LocalDate.now());
	}

	public Subscription addSubscription(Long memberId, Long planId) {
		Member member = memberService.getMemberById(memberId);
		Plan plan = planService.getPlanById(planId);

		Subscription subscription = new Subscription();
		subscription.setMember(member);
		subscription.setPlan(plan);
		subscription.setStartDate(LocalDate.now());
		// End date = start date + plan duration
		subscription.setEndDate(LocalDate.now().plusDays(plan.getDurationInDays()));

		return subscriptionRepository.save(subscription);
	}

	public void deleteSubscription(Long id) {
		Subscription subscription = getSubscriptionById(id);
		subscriptionRepository.delete(subscription);
	}
}

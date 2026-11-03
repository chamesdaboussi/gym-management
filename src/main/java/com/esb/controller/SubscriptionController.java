package com.esb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.esb.model.Subscription;
import com.esb.service.SubscriptionService;

@RestController
@RequestMapping("/api/subscriptions")
public class SubscriptionController {
	@Autowired
	private SubscriptionService subscriptionService;

	@GetMapping
	public List<Subscription> getAllSubscriptions() {
		return subscriptionService.getAllSubscriptions();
	}

	@GetMapping("/{id}")
	public Subscription getSubscriptionById(@PathVariable Long id) {
		return subscriptionService.getSubscriptionById(id);
	}

	@GetMapping("/expired")
	public List<Subscription> getExpiredSubscriptions() {
		return subscriptionService.getExpiredSubscriptions();
	}

	@PostMapping("/{memberId}/{planId}")
	public Subscription addSubscription(@PathVariable Long memberId, @PathVariable Long planId) {
		return subscriptionService.addSubscription(memberId, planId);
	}

	@DeleteMapping("/{id}")
	public String deleteSubscription(@PathVariable Long id) {
		subscriptionService.deleteSubscription(id);
		return "Subscription deleted";
	}
}

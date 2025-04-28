package com.aits.mobileprepaid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aits.mobileprepaid.Service.RechargeService;
import com.aits.mobileprepaid.entity.RechargeHistory;

@RestController
public class RechargeController {
	@Autowired
	private RechargeService service;
	
	@PostMapping("/recharge")
	public String recharge(@RequestParam Long userId, 
							@RequestParam Integer planId,
							@RequestParam String paymentMethod) {
		return service.recharge(userId, planId, paymentMethod);
	}
	
	@GetMapping("recharge/history/{userId}")
	public List<RechargeHistory> getHistory(@PathVariable Long userId){
		return service.getUserHistory(userId);
	}
	
}

package com.aits.mobileprepaid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aits.mobileprepaid.Service.RechargePlanService;
import com.aits.mobileprepaid.entity.RechargePlan;

@RestController
@RequestMapping("/plans")
public class RechargePlanController {
	@Autowired
	private RechargePlanService service;
	
	@PostMapping
	
	public RechargePlan insert(@RequestBody RechargePlan plan) {
		return service.insert(plan);
	}
	@GetMapping
	public List<RechargePlan> getAllPlans(){
		return service.getAllplans();
	}
	@GetMapping("/{category}")
	public List<RechargePlan> getByCategory(@PathVariable String category){
		return service.getPlanByCategory(category);
	}
	
	
}

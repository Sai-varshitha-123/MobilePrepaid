package com.aits.mobileprepaid.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aits.mobileprepaid.entity.RechargePlan;
import com.aits.mobileprepaid.repository.RechargePlanRepo;

@Service
public class RechargePlanService {
	@Autowired
	RechargePlanRepo repo;
	
	public RechargePlan insert(RechargePlan plan) {
		return repo.save(plan);
	}
	public List<RechargePlan> getAllplans(){
	return repo.findAll();
	}
	public List<RechargePlan> getPlanByCategory(String Category){
		return repo.findByCategory(Category);
	}
}

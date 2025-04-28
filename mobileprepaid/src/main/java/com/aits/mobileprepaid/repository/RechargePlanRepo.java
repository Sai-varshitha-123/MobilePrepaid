package com.aits.mobileprepaid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aits.mobileprepaid.entity.RechargePlan;

public interface RechargePlanRepo extends JpaRepository<RechargePlan, Integer> {
   List<RechargePlan> findByCategory(String category);
}

package com.aits.mobileprepaid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aits.mobileprepaid.entity.RechargeHistory;

public interface RechargeHistoryRepo extends JpaRepository<RechargeHistory,Long>{
	List<RechargeHistory> findByUserId(Long id);

}

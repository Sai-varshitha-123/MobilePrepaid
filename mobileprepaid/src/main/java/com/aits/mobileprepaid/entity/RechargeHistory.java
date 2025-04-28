package com.aits.mobileprepaid.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class RechargeHistory {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;
	@ManyToOne
  private User user;
	@ManyToOne
  private RechargePlan plan;
  private String PaymentMethod;
  private LocalDateTime RechargeDate;
  
  public RechargeHistory() {
	  
  }
  public RechargeHistory(String PaymentMethod,LocalDateTime RechargeDate) {
	  this.PaymentMethod=PaymentMethod;
	  this.RechargeDate=RechargeDate;
  }
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public RechargePlan getPlan() {
	return plan;
}
public void setPlan(RechargePlan plan) {
	this.plan = plan;
}
public String getPaymentMethod() {
	return PaymentMethod;
}
public void setPaymentMethod(String paymentMethod) {
	PaymentMethod = paymentMethod;
}
public LocalDateTime getRechargeDate() {
	return RechargeDate;
}
public void setRechargeDate(LocalDateTime rechargeDate) {
	RechargeDate = rechargeDate;
}
  
}

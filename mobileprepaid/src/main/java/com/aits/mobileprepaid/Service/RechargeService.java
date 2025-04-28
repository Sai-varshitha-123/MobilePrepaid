package com.aits.mobileprepaid.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.aits.mobileprepaid.entity.RechargeHistory;
import com.aits.mobileprepaid.entity.RechargePlan;
import com.aits.mobileprepaid.entity.User;
import com.aits.mobileprepaid.repository.RechargeHistoryRepo;
import com.aits.mobileprepaid.repository.RechargePlanRepo;
import com.aits.mobileprepaid.repository.UserRepo;

@Service
public class RechargeService {
	@Autowired
	private UserRepo userrepo;
	@Autowired
	private RechargePlanRepo planrepo;
	@Autowired
	private RechargeHistoryRepo historyrepo;
    @Autowired
    private JavaMailSender mailSender;
    
    public  String recharge(Long userId,Integer planID,String paymentMethod) {
    	Optional<User> userOpt=userrepo.findById(userId);
    	Optional<RechargePlan> planopt=planrepo.findById(planID);
    	if(userOpt.isEmpty() || planopt.isEmpty()) {
    		return "user or plan not found";
    	}
    	
    	RechargeHistory history=new RechargeHistory();
    	history.setUser(userOpt.get());
    	history.setPlan(planopt.get());
    	history.setPaymentMethod(paymentMethod);
    	history.setRechargeDate(LocalDateTime.now());
    	
    	historyrepo.save(history);
    	
    	sendConfirmationemail(userOpt.get().getemail(),planopt.get());
    	return "recharge Successful";
    	
    	
    }

	private void sendConfirmationemail(String email,RechargePlan plan) {
		SimpleMailMessage message=new SimpleMailMessage();
		message.setTo(email);
		message.setSubject("Recharge Confirmation");
		message.setText("you have succesfully recharged with "+plan.getName()
						+" |price Rs. "+plan.getPrice()+" |validity "+plan.getValidityDays() +" Days ");
		mailSender.send(message);
		
	}
	
	public List<RechargeHistory> getUserHistory(Long userId){
		return historyrepo.findByUserId(userId);
	}
}

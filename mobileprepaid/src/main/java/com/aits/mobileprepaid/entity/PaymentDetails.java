package com.aits.mobileprepaid.entity;

public class PaymentDetails {
 private String method;
 private String upiid;
 private String Bankaccount;
 private String cardNumber;
 public PaymentDetails() {
	 
 }
 public PaymentDetails(String method,String upiid,String Bankaccount,String cardnumber) {
	 this.method=method;
	 this.upiid=upiid;
	 this.Bankaccount=Bankaccount;
	 this.cardNumber=cardnumber;
 }
public String getMethod() {
	return method;
}
public void setMethod(String method) {
	this.method = method;
}
public String getUpiid() {
	return upiid;
}
public void setUpiid(String upiid) {
	this.upiid = upiid;
}
public String getBankaccount() {
	return Bankaccount;
}
public void setBankaccount(String bankaccount) {
	Bankaccount = bankaccount;
}
public String getCardNumber() {
	return cardNumber;
}
public void setCardNumber(String cardNumber) {
	this.cardNumber = cardNumber;
}
 
}

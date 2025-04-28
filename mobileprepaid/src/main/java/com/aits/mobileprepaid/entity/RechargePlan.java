package com.aits.mobileprepaid.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class RechargePlan {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
private String name;
private String category;
private double price;
private int validityDays;

public RechargePlan() {
	
}
public RechargePlan(String name,String category,double price,int validityDays) {
	this.name=name;
	this.category=category;
	this.price=price;
	this.validityDays=validityDays;

}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getcategory() {
	return category;
}
public void setcategory(String category) {
	this.category = category;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getValidityDays() {
	return validityDays;
}
public void setValidityDays(int validityDays) {
	this.validityDays = validityDays;
}

}

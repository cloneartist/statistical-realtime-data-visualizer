package com.stackroute.dataanalyticsservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private Long customer_id;
	private int credit_id;
	private String Country;
	private String gender;
	private int age;
	private int balance;
	private int credit_card;
	private float estimated_salary;
	
	
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public int getCredit_id() {
		return credit_id;
	}
	public void setCredit_id(int credit_id) {
		this.credit_id = credit_id;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int getCredit_card() {
		return credit_card;
	}
	public void setCredit_card(int credit_card) {
		this.credit_card = credit_card;
	}
	public float getEstimated_salary() {
		return estimated_salary;
	}
	public void setEstimated_salary(float estimated_salary) {
		this.estimated_salary = estimated_salary;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", credit_id=" + credit_id + ", Country=" + Country
				+ ", gender=" + gender + ", age=" + age + ", balance=" + balance + ", credit_card=" + credit_card
				+ ", estimated_salary=" + estimated_salary + "]";
	}
	
	
	
	
}


//normalized data - {
//	   "customer_id": 15634602,
//	   "credit_score": 619,
//	   "country": "France",
//	   "gender": "Female",
//	   "age": 42,
//	   "balance": 0,
//	   "credit_card": 1,
//	   "estimated_salary": 101348.88,
//	 }
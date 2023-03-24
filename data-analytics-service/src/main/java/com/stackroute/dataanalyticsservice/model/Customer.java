package com.stackroute.dataanalyticsservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private Long customer_id;
	private int credit_score;
	private String country;
	private String gender;
	private int age;
	private int balance;
	private int credit_card;
	private double estimated_salary;
	
	
	public Long getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}
	public int getCredit_score() {
		return credit_score;
	}
	public void setCredit_score(int credit_score) {
		this.credit_score = credit_score;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public double getEstimated_salary() {
		return estimated_salary;
	}
	public void setEstimated_salary(double estimated_salary) {
		this.estimated_salary = estimated_salary;
	}
	
	
	@Override
	public String toString() {
		return "Customer [customer_id=" + customer_id + ", credit_id=" + credit_score + ", Country=" + country
				+ ", gender=" + gender + ", age=" + age + ", balance=" + balance + ", credit_card=" + credit_card
				+ ", estimated_salary=" + estimated_salary + "]";
	}
	
	
	
	
}
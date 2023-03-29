package com.stackroute.dataanalyticsservice.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;


//This model is used while receiving the data from kafka which is not in the Customer format
@Entity
public class BankRecieveModel {

	@Id
	@Column(name = "customer_id", length = 30)
	private String customer_id;
	@Column(name = "credit_score", length = 30)
	private String credit_score;
	@Column(name = "country", length = 10)
	private String country;
	@Column(name = "gender", length = 20)
	private String gender;
	@Column(name = "age", length = 3)
	private String age;
	@Column(name = "balance", length = 20)
	private String balance;
	@Column(name = "credit_card", length = 2)
	private String credit_card;
	@Column(name = "estimated_salary", length = 30)
	private String estimated_salary;

	public String getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}

	public String getCredit_score() {
		return credit_score;
	}

	public void setCredit_score(String credit_score) {
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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getCredit_card() {
		return credit_card;
	}

	public void setCredit_card(String credit_card) {
		this.credit_card = credit_card;
	}

	public String getEstimated_salary() {
		return estimated_salary;
	}

	public void setEstimated_salary(String estimated_salary) {
		this.estimated_salary = estimated_salary;
	}

	@Override
	public String toString() {
		return "Bank [customer_id=" + customer_id + ", credit_score=" + credit_score + ", country=" + country
				+ ", gender=" + gender + ", age=" + age + ", balance=" + balance + ", credit_card=" + credit_card
				+ ", estimated_salary=" + estimated_salary + "]";
	}
}

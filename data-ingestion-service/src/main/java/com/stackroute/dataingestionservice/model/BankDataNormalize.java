package com.stackroute.dataingestionservice.model;

public class BankDataNormalize {

	private String customer_id;
	private String credit_score;
	private String country;
	private String gender;
	private String age;
	private String balance;
	private String credit_card;
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

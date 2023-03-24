package com.stackroute.dataingestionservice.model;

public class User {
	private int customer_id;
	private int credit_score;
	private String country;
	private String gender;
	private int age;
	private int tenure;
	private float balance;
	private int products_number;
	private int credit_card;
	private int active_member;
	private float estimated_salary;
	private int churn;

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
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

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public int getProducts_number() {
		return products_number;
	}

	public void setProducts_number(int products_number) {
		this.products_number = products_number;
	}

	public int getCredit_card() {
		return credit_card;
	}

	public void setCredit_card(int credit_card) {
		this.credit_card = credit_card;
	}

	public int getActive_member() {
		return active_member;
	}

	public void setActive_member(int active_member) {
		this.active_member = active_member;
	}

	public float getEstimated_salary() {
		return estimated_salary;
	}

	public void setEstimated_salary(float estimated_salary) {
		this.estimated_salary = estimated_salary;
	}

	public int getChurn() {
		return churn;
	}

	public void setChurn(int churn) {
		this.churn = churn;
	}

	@Override
	public String toString() {
		return "User [customer_id=" + customer_id + ", credit_score=" + credit_score + ", country=" + country
				+ ", gender=" + gender + ", age=" + age + ", tenure=" + tenure + ", balance=" + balance
				+ ", products_number=" + products_number + ", credit_card=" + credit_card + ", active_member="
				+ active_member + ", estimated_salary=" + estimated_salary + ", churn=" + churn + "]";
	}
}
package com.stackroute.dataanalyticsservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Country{
	
	@Id
	private String name;
	private int numberOfCustomers;
	private float averageCreditScore;
	private float averageSalary;
	
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Country(String name, int numberOfCustomers, float averageCreditScore, float averageSalary) {
		super();
		this.name = name;
		this.numberOfCustomers = numberOfCustomers;
		this.averageCreditScore = averageCreditScore;
		this.averageSalary = averageSalary;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNumberOfCustomers() {
		return numberOfCustomers;
	}
	public void setNumberOfCustomers(int numberOfCustomers) {
		this.numberOfCustomers = numberOfCustomers;
	}
	public float getAverageCreditScore() {
		return averageCreditScore;
	}
	public void setAverageCreditScore(float averageCreditScore) {
		this.averageCreditScore = averageCreditScore;
	}
	public float getAverageSalary() {
		return averageSalary;
	}
	public void setAverageSalary(float averageSalary) {
		this.averageSalary = averageSalary;
	}
	
	@Override
	public String toString() {
		return "Country [name=" + name + ", numberOfCustomers=" + numberOfCustomers + ", averageCreditScore="
				+ averageCreditScore + ", averageSalary=" + averageSalary + "]";
	}
	
	
	
	
	
}

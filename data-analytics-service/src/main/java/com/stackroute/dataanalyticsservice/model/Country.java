package com.stackroute.dataanalyticsservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Country{
	
	
	@Id
	private String name;
	private int numberOfCustomers;
	private double averageCreditScore;
	private double averageSalary;
	
	
	
	
	public Country() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Country(String name, int numberOfCustomers, double averageCreditScore, double averageSalary) {
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
	public double getAverageCreditScore() {
		return averageCreditScore;
	}
	public void setAverageCreditScore(double averageCreditScore) {
		this.averageCreditScore = averageCreditScore;
	}
	public double getAverageSalary() {
		return averageSalary;
	}
	public void setAverageSalary(double averageSalary) {
		this.averageSalary = averageSalary;
	}
	
	@Override
	public String toString() {
		return "Country [name=" + name + ", numberOfCustomers=" + numberOfCustomers + ", averageCreditScore="
				+ averageCreditScore + ", averageSalary=" + averageSalary + "]";
	}
	
	
	
	
	
	
	
}

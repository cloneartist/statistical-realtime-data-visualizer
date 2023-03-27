package com.stackroute.dataanalyticsservice.entity;

public class NameAndSalary {
	private String name;
	private double averageSalary;
	

	public NameAndSalary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public NameAndSalary(String name, double averageSalary) {
		super();
		this.name = name;
		this.averageSalary = averageSalary;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAverageSalary() {
		return averageSalary;
	}
	public void setAverageSalary(double averageSalary) {
		this.averageSalary = averageSalary;
	}
	
	
}

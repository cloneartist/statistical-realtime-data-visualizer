package com.stackroute.dataanalyticsservice.entity;

public class NameAndSalary {
	private String name;
	private float averageSalary;
	

	public NameAndSalary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public NameAndSalary(String name, float averageSalary) {
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
	public float getAverageSalary() {
		return averageSalary;
	}
	public void setAverageSalary(float averageSalary) {
		this.averageSalary = averageSalary;
	}
	
	
}

package com.stackroute.dataanalyticsservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//This model is just created to fetch the name,number of customer from country table (Refer custom query in the country repository)
public class NameAndCustomers {
	
	
	public NameAndCustomers() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public NameAndCustomers(String name, int numberOfCustomers) {
		super();
		this.name = name;
		this.numberOfCustomers = numberOfCustomers;
	}


	
	private String name;
	private int numberOfCustomers;
	
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
	
	
}

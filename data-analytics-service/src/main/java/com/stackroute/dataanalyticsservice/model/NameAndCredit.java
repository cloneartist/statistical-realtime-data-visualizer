package com.stackroute.dataanalyticsservice.entity;

public class NameAndCredit {
	private String name;
	private float averageCreditScore;
	
	
	
	
	public NameAndCredit() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	public NameAndCredit(String name, float averageCreditScore) {
		super();
		this.name = name;
		this.averageCreditScore = averageCreditScore;
	}




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getAverageCreditScore() {
		return averageCreditScore;
	}
	public void setAverageCreditScore(float averageCreditScore) {
		this.averageCreditScore = averageCreditScore;
	}
	
	
}

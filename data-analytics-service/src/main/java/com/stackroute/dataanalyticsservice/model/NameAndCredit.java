package com.stackroute.dataanalyticsservice.model;

public class NameAndCredit {
	private String name;
	private double averageCreditScore;

	public NameAndCredit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NameAndCredit(String name, double averageCreditScore) {
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

	public double getAverageCreditScore() {
		return averageCreditScore;
	}

	public void setAverageCreditScore(double averageCreditScore) {
		this.averageCreditScore = averageCreditScore;
	}

}

package com.lti.projectgladiator.ltinsure.dto;

public class PremiumDto {

	private String type;

	private int age;

	private String model;

	private int duration;

	private double lossSuffered;

	private double totalCostOfVehicle;

	private double amount;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getLossSuffered() {
		return lossSuffered;
	}

	public void setLossSuffered(double lossSuffered) {
		this.lossSuffered = lossSuffered;
	}

	public double getTotalCostOfVehicle() {
		return totalCostOfVehicle;
	}

	public void setTotalCostOfVehicle(double totalCostOfVehicle) {
		this.totalCostOfVehicle = totalCostOfVehicle;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}

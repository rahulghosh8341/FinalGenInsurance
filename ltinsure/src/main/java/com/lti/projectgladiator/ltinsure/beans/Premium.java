package com.lti.projectgladiator.ltinsure.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "PREMIUM_ESTIMATE_MOTOR")
public class Premium {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="premium_id_seq")
	@SequenceGenerator(name = "premium_id_seq",initialValue=90001, sequenceName = "premium_id_seq", allocationSize = 1)
	@Column(name = "premium_id")
	private int id;

	@Column(name = "vehicle_type")
	private String type;

	@Column(name = "age")
	private int age;

	@Column(name = "model")
	private String model;

	@Column(name = "amount")
	private double amount;

	@Column(name = "depreciation_rate")
	private int depreciationRate;
	
	@Column(name = "duration")
	private int duration;
	
	@Column(name = "loss_suffered")
	private double lossSuffered;
	
	@Column(name = "total_cost_of_vehicle")
	private double totalCostOfVehicle;

	public double getTotalCostOfVehicle() {
		return totalCostOfVehicle;
	}

	public void setTotalCostOfVehicle(double totalCostOfVehicle) {
		this.totalCostOfVehicle = totalCostOfVehicle;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	@JsonIgnore
	public double getLossSuffered() {
		return lossSuffered;
	}

	public void setLossSuffered(double lossSuffered) {
		this.lossSuffered = lossSuffered;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@JsonIgnore
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	@JsonIgnore
	public int getDepreciationRate() {
		return depreciationRate;
	}

	public void setDepreciationRate(int depreciationRate) {
		this.depreciationRate = depreciationRate;
	}

	@Override
	public String toString() {
		return "Premium [id=" + id + ", type=" + type + ", age=" + age + ", model=" + model + ", amount=" + amount
				+ ", depreciationRate=" + depreciationRate + ", duration=" + duration + ", lossSuffered=" + lossSuffered
				+ ", totalCostOfVehicle=" + totalCostOfVehicle + "]";
	}
	
	

}

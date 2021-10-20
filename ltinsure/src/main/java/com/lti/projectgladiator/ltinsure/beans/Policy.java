package com.lti.projectgladiator.ltinsure.beans;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "POLICY")
public class Policy {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="policy_id_seq")
	@SequenceGenerator(name = "policy_id_seq",initialValue=30001, sequenceName = "policy_id_seq", allocationSize = 1)
	@Column(name = "policy_id")
	private int id;

	@Column(name = "status")
	private String status;

	@JsonIgnore
	@Column(name = "issue_date")
	private LocalDate issueDate;

	@JsonIgnore
	@Column(name = "expiry_date")
	private LocalDate expiryDate;

	@Column(name = "duration")
	private int duration;

	@Column(name = "policy_amount")
	private double policyAmount;

	@Column(name = "plan_amount")
	private double planAmount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "insurance_id")
	private InsurancePlan insurancePlan;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vehicle_id")
	private Vehicle vehicle;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getPolicyAmount() {
		return policyAmount;
	}

	public void setPolicyAmount(double policyAmount) {
		this.policyAmount = policyAmount;
	}

	public double getPlanAmount() {
		return planAmount;
	}
	public void setPlanAmount(double planAmount) {
		this.planAmount = planAmount;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public InsurancePlan getInsurancePlan() {
		return insurancePlan;
	}

	public void setInsurancePlan(InsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	

}

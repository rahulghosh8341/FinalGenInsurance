package com.lti.projectgladiator.ltinsure.dto;

import java.time.LocalDate;

public class PolicyDto {
	
	private LocalDate issueDate;
	private LocalDate expiryDate;
	private String duration;
	private int policyAmount;
	private int planAmount;
	private int customerid;
	private int insurancePlanid;
	private int vehicleId;
	
	

	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	private String status;
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public int getPolicyAmount() {
		return policyAmount;
	}
	public void setPolicyAmount(int policyAmount) {
		this.policyAmount = policyAmount;
	}
	public int getPlanAmount() {
		return planAmount;
	}
	public void setPlanAmount(int planAmount) {
		this.planAmount = planAmount;
	}
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public int getInsurancePlanid() {
		return insurancePlanid;
	}
	public void setInsurancePlanid(int insurancePlanid) {
		this.insurancePlanid = insurancePlanid;
	}
	
}

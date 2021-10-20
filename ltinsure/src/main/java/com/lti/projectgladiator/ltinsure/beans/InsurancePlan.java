package com.lti.projectgladiator.ltinsure.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "INSURANCE_PLAN")
public class InsurancePlan {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="insurance_id_seq")
	@SequenceGenerator(name = "insurance_id_seq",initialValue=40001, sequenceName = "insurance_id_seq", allocationSize = 1)
	@Column(name = "insurance_id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "insurance_type")
	private String type;//third party or comprehensive
	
	@Column(name = "amount")
	private double amount;//2000
	
	@Column(name = "commission")
	private int commission;//500
	
	@Column(name = "company_name")
	private String companyName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}	

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}

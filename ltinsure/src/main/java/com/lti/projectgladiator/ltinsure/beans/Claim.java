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


@Entity
@Table(name = "CLAIM_HISTORY")
public class Claim {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="claim_id_seq")
	@SequenceGenerator(name = "claim_id_seq",initialValue=60001, sequenceName = "claim_id_seq", allocationSize = 1)
	@Column(name = "claim_id")
	private int id;

	@Column(name = "claim_date")
	private LocalDate date;

	@Column(name = "status")
	private String status;//approved or pending, not approved 

	@Column(name = "amount")
	private double amount;

	@Column(name = "reason")
	private String reason;

	@Column(name = "contact_no")
	private long contactNo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "policy_id")
	private Policy policy;

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public long getContactNo() {
		return contactNo;
	}

	public void setContactNo(long l) {
		this.contactNo = l;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	

}
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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="payment_id_seq")
	@SequenceGenerator(name = "payment_id_seq",initialValue=70001, sequenceName = "payment_id_seq", allocationSize = 1)
	@Column(name = "payment_id")
	private int id;

	@Column(name = "payment_mode")
	private String mode;

	@Column(name = "payment_date")
	private LocalDate date;

	@Column(name = "payment_amount")
	private double amount;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}

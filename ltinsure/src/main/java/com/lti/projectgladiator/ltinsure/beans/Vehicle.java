package com.lti.projectgladiator.ltinsure.beans;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="vehicle_id_seq")
	@SequenceGenerator(name = "vehicle_id_seq",initialValue=50001, sequenceName = "vehicle_id_seq", allocationSize = 1)
	@Column(name = "vehicle_id")
	private int id;
	
	@Column(name = "vehicle_type")
	private String type;
	
	@Column(name = "model")
	private String model;
	
	@Column(name = "manufacturer")
	private String manufacturer;
	
	@Column(name = "driving_license", unique = true)
	private String drivingLicense;
	
	@Column(name = "purchase_date")
	private LocalDate purchaseDate;
	
	@Column(name = "registration_no", unique = true)
	private String registrationNo;
	
	@Column(name = "engine_no",unique = true)
	private String engineNo;
	
	@Column(name = "chassis_no", unique = true)
	private String chassisNo;
	
	@Column(name = "engine_type")
	private String engineType;  //petrol/diesel
	
	@Column(name = "last_renew_date")
	private LocalDate lastRenewDate;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public LocalDate getLastRenewDate() {
		return lastRenewDate;
	}

	public void setLastRenewDate(LocalDate lastRenewDate) {
		this.lastRenewDate = lastRenewDate;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getRegistrationNo() {
		return registrationNo;
	}
	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}
	public String getEngineNo() {
		return engineNo;
	}
	public void setEngineNo(String engineNo) {
		this.engineNo = engineNo;
	}
	public String getChassisNo() {
		return chassisNo;
	}
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
}

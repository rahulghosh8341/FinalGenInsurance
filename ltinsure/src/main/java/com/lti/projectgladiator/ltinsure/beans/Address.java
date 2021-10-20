package com.lti.projectgladiator.ltinsure.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="addr_id_seq")
	@SequenceGenerator(name = "addr_id_seq",initialValue=80001, sequenceName = "addr_id_seq", allocationSize = 1)
	@Column(name = "addr_id")
	private int id;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "pincode")
	private int pincode;
	
	@Column(name = "landMark")
	private String landMark;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getLandMark() {
		return landMark;
	}
	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}
	
}
package com.lti.projectgladiator.ltinsure.dao;

import java.util.List;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.InsurancePlan;
import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.beans.Vehicle;

public interface PolicyDao {
	
	boolean isSameVehicleIsInsuredAlready(String registrationNo);
	
	int submissionOfBuyInsuranceData(Vehicle vehicle);
	
	void submitPolicyDate(Policy policy);
	
	Customer findById(int id);

	List<InsurancePlan> getAllInsuranceData();
	List<Policy> getAllPolicy();
	
	InsurancePlan findInsuranceById(int id);
	
	Vehicle findVehicleById(int id);
}

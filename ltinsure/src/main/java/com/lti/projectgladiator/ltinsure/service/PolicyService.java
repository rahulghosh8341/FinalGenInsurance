package com.lti.projectgladiator.ltinsure.service;

import java.util.List;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.InsurancePlan;
import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.beans.Vehicle;
import com.lti.projectgladiator.ltinsure.exception.InsuranceServiceException;

public interface PolicyService {

	int submissionOfBuyInsuranceDetails(Vehicle vehicle) throws InsuranceServiceException;
	
	void submitePolicyDetails(Policy policy) throws InsuranceServiceException;
	Customer findById(int id);
	List<InsurancePlan> getAllInsurancePlan();
	List<Policy> getAllPolicies();
	Vehicle getVehicleById(int id);
	InsurancePlan getInsuranceById(int id);
}

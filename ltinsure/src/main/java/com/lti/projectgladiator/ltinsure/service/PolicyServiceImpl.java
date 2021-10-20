package com.lti.projectgladiator.ltinsure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.InsurancePlan;
import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.beans.Vehicle;
import com.lti.projectgladiator.ltinsure.dao.PolicyDao;
import com.lti.projectgladiator.ltinsure.exception.InsuranceServiceException;

@Service
public class PolicyServiceImpl implements PolicyService {
	@Autowired
	private PolicyDao buyInsuranceRepo;
	
	@Override
	public int submissionOfBuyInsuranceDetails(Vehicle vehicle) throws InsuranceServiceException {
		if(!buyInsuranceRepo.isSameVehicleIsInsuredAlready(vehicle.getRegistrationNo())) {
			return buyInsuranceRepo.submissionOfBuyInsuranceData(vehicle);
		}else {
			throw new InsuranceServiceException("This Vehicle is already Insured, you have to renew the insurance");
		}
	}
	
	@Override
	public void submitePolicyDetails(Policy policy) throws InsuranceServiceException  {
		buyInsuranceRepo.submitPolicyDate(policy);
	}

	@Override
	public Customer findById(int id) {
		return buyInsuranceRepo.findById(id);
}
	
	@Override
	public List<InsurancePlan> getAllInsurancePlan(){
		List<InsurancePlan> list = buyInsuranceRepo.getAllInsuranceData();
		return list;
		
}

	@Override
	public InsurancePlan getInsuranceById(int id) {
		
		return buyInsuranceRepo.findInsuranceById(id);
	}

	@Override
	public List<Policy> getAllPolicies() {
		List<Policy> list = buyInsuranceRepo.getAllPolicy();
		return list;
	}

	@Override
	public Vehicle getVehicleById(int id) {
		return buyInsuranceRepo.findVehicleById(id);
	}

	
	
}

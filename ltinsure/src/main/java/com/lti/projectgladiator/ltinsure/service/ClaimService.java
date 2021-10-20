package com.lti.projectgladiator.ltinsure.service;

import java.util.List;

import com.lti.projectgladiator.ltinsure.beans.Claim;
import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.exception.InsuranceServiceException;

public interface ClaimService {

	Claim saveAndUpdateOfClaimInsuranceDetails(Claim claim) throws InsuranceServiceException;

	List<Claim> getClaimInsuranceData() throws InsuranceServiceException;

	Claim getClaimDataById(int id);

	Customer findByCustomerId(int id);

	Policy findByPolicyId(int id);


}

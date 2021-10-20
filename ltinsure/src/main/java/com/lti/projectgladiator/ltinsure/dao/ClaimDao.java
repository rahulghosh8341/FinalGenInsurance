package com.lti.projectgladiator.ltinsure.dao;

import java.util.List;

import com.lti.projectgladiator.ltinsure.beans.Claim;
import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.Policy;

public interface ClaimDao {

	Claim submitAndUpdatingOfClaimInsurance(Claim claim);

	Claim fetchDataByIdForClaimInsurance(int id);

	List<Claim> fetchAllClaimData();

	Customer findByCustomerId(int id);

	Policy findByPolicyId(int id);

	Claim getRecent();

}


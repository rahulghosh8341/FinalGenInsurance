package com.lti.projectgladiator.ltinsure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.projectgladiator.ltinsure.beans.Claim;
import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.dao.ClaimDao;
import com.lti.projectgladiator.ltinsure.exception.InsuranceServiceException;

@Service
public class ClaimServiceImpl implements ClaimService {
	@Autowired
	private ClaimDao claimInsuranceRepo;

	@Override
	public Claim saveAndUpdateOfClaimInsuranceDetails(Claim claim) throws InsuranceServiceException {
		return claimInsuranceRepo.submitAndUpdatingOfClaimInsurance(claim);
	}

	@Override
	public List<Claim> getClaimInsuranceData() throws InsuranceServiceException {
		List<Claim> list = claimInsuranceRepo.fetchAllClaimData();
		return list;
	}

	@Override
	public Claim getClaimDataById(int id) {
		Claim claim = claimInsuranceRepo.fetchDataByIdForClaimInsurance(id);
		return claim;
	}

	@Override
	public Customer findByCustomerId(int id) {
		return claimInsuranceRepo.findByCustomerId(id);
	}

	@Override
	public Policy findByPolicyId(int id) {
		return claimInsuranceRepo.findByPolicyId(id);
	}

	
}

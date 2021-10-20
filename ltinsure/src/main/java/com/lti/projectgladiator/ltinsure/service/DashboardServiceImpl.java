package com.lti.projectgladiator.ltinsure.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.projectgladiator.ltinsure.beans.Claim;
import com.lti.projectgladiator.ltinsure.dao.DashboardDao;

@Service
public class DashboardServiceImpl implements DashboardService{

	@Autowired
	private DashboardDao dashboardRepo;
	
	@Override
	public List<Claim> fetchByProcessingStatusService(String processingStatus){
		List<Claim> list = dashboardRepo.fetchByProcessingStatus(processingStatus);
		return list;
	}
	
	@Override
	public long getCountRenewService() {
		long count = dashboardRepo.getCountRenew();
		return count;
	}
	
	@Override
	public long getCountCustomerService() {
		long count = dashboardRepo.getCountCustomer();
		return count;
	}
	
	@Override
	public long getCountClaimService() {
		long count = dashboardRepo.getCountClaim();
		return count;
	}
	
	@Override
	public long getCountPolicyService() {
		long count = dashboardRepo.getCountPolicy();
		return count;
	}
}

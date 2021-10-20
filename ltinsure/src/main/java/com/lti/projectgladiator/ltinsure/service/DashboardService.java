package com.lti.projectgladiator.ltinsure.service;

import java.util.List;

import com.lti.projectgladiator.ltinsure.beans.Claim;

public interface DashboardService {

	List<Claim> fetchByProcessingStatusService(String processingStatus);

	long getCountCustomerService();

	long getCountClaimService();

	long getCountPolicyService();
	
	long getCountRenewService();

}
package com.lti.projectgladiator.ltinsure.dao;

import java.util.List;

import com.lti.projectgladiator.ltinsure.beans.Claim;

public interface DashboardDao {

	List<Claim> fetchByProcessingStatus(String processingStatus);

	long getCountCustomer();

	long getCountClaim();

	long getCountPolicy();
	
	long getCountRenew();
	
	long getUserInsuranceCount(int id);
	
	long getUserClaimCount(int id);
	
	long getUserRenewCount(int id);
	
	long getUserDashboardData(int id);

}

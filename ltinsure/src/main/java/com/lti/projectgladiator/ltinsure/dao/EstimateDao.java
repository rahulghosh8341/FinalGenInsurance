package com.lti.projectgladiator.ltinsure.dao;

import com.lti.projectgladiator.ltinsure.beans.Premium;

public interface EstimateDao {

	void save(Premium premium);

	double estimateClaimAmount(Premium premium);

}
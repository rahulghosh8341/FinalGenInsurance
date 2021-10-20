package com.lti.projectgladiator.ltinsure.service;

import com.lti.projectgladiator.ltinsure.beans.Premium;

public interface EstimateService {

	double estimateClaim(Premium premium);
	
	void saveData(Premium premium);

}

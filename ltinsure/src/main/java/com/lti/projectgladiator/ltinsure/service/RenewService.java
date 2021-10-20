package com.lti.projectgladiator.ltinsure.service;

import com.lti.projectgladiator.ltinsure.beans.Policy;
import com.lti.projectgladiator.ltinsure.status.Status;

public interface RenewService {

	Status renewIns(Policy policy);

}

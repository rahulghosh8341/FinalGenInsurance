package com.lti.projectgladiator.ltinsure.dao;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.Policy;

public interface RenewDao {

	void save(Object obj);

	Policy findByPolicyId(int id);

	boolean isPolicyPresent(int id);
	
	boolean isPolicyExpired(int id);
	
	public Customer findCustomerByPolicyId(int id);

}
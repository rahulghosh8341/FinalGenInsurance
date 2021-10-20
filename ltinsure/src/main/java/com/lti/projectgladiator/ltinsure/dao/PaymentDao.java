package com.lti.projectgladiator.ltinsure.dao;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.Payment;

public interface PaymentDao {

	void save(Object obj);

	Payment findPaymentDetailsByCustomerId(Customer customer);

	public boolean isUserValid(String email);

	int findCustomerIdByEmail(String email);
	
	public Customer getCustomerByEmail(String email);
}

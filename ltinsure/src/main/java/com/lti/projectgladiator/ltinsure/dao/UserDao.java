package com.lti.projectgladiator.ltinsure.dao;

import java.util.List;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.User;

public interface UserDao {

    void save(Customer customer);
    
    void save(User user);

	Customer findCustomerById(int id);

	List<Customer> findAll();

	User findByEmailPassword(String email, String password);

	boolean isCustomerPresent(String email);

	boolean isUserPresent(String email);
	
	User findUserByOtp(String otp);
	 
	User findUserByEmail(String email);

}

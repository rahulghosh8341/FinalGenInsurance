package com.lti.projectgladiator.ltinsure.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.User;
import com.lti.projectgladiator.ltinsure.dao.UserDao;
import com.lti.projectgladiator.ltinsure.exception.UserServiceException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userRepository;

	@Override
	public void register(Customer customer) {
		if (!userRepository.isCustomerPresent(customer.getEmailId())) {
			userRepository.save(customer);
		} else {
			throw new UserServiceException("Customer already registered");
		}

	}

	@Override
	public void register(User user) {

		// using isCustomerPresent of Customer entity again
		if (!userRepository.isCustomerPresent(user.getEmailId())) {
			userRepository.save(user);
		} else {
			throw new UserServiceException("User already registered");
		}

	}

	@Override
	public List<String> login(String email, String password) {
		try {

			User user = userRepository.findByEmailPassword(email, UserService.getHashedString(password));
			Customer customer = userRepository.findCustomerById(user.getCustomer().getId());

			List<String> sessionData = new ArrayList<>();
			sessionData.add("" + customer.getId());
			sessionData.add(customer.getName());
			sessionData.add(user.getRole());

			return sessionData;

		} catch (Exception e) {
			e.printStackTrace();
			throw new UserServiceException("Error checking password");
		}

	}

	@Override
	public boolean isUserPresent(String email) {
		if (!userRepository.isUserPresent(email)) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public User getUserByEmailandPassword(String email, String password) {

		try {
			User user = userRepository.findByEmailPassword(email, UserService.getHashedString(password));
			return user;
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public void addOrUpdateUser(User user) {
		userRepository.save(user);
	}

	@Override
	public User getUserByOtp(String otp) {
		return userRepository.findUserByOtp(otp);
	}

	@Override
	public Customer getCustomerById(int id) {
		return userRepository.findCustomerById(id);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findUserByEmail(email);
	}

}
package com.lti.projectgladiator.ltinsure.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.User;

public interface UserService {

	void register(Customer customer) throws Exception;

	void register(User user) throws Exception;

	List<String> login(String email, String password);

	boolean isUserPresent(String email);

	Customer getCustomerById(int id);

	User getUserByEmailandPassword(String email, String password);

	void addOrUpdateUser(User user);

	User getUserByOtp(String otp);

	User getUserByEmail(String email);
	
	public static String getHashedString(String text) {
//		try {
//		text = Base64.getEncoder().encodeToString(text.getBytes());
//
//		MessageDigest md = MessageDigest.getInstance("MD5");
//		md.update(text.getBytes());
//
//		byte[] digest = md.digest();
//		text = DatatypeConverter.printHexBinary(digest).toUpperCase();
//
//		return text;
//
//	} catch (Exception e) {
//		return Base64.getEncoder().encodeToString(text.getBytes());
//	}
	return text;
	}

	public static String generateOtp() {
		StringBuilder generatedOTP = new StringBuilder();
		SecureRandom secureRandom = new SecureRandom();
		try {

			secureRandom = SecureRandom.getInstance(secureRandom.getAlgorithm());

			for (int i = 0; i < 6; i++) {
				generatedOTP.append(secureRandom.nextInt(9));
			}
		} catch (NoSuchAlgorithmException e) {
			// e.printStackTrace();
			return null;
		}

		return generatedOTP.toString();
	}

}

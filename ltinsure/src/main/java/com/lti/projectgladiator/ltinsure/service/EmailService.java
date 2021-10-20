package com.lti.projectgladiator.ltinsure.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
	public boolean sendEmail(SimpleMailMessage email);
	public void sendSimpleMessage(String to, String subject, String text);
	
}

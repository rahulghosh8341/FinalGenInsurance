package com.lti.projectgladiator.ltinsure.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

	
	private JavaMailSender mailSender;
	
	@Autowired
	public EmailServiceImpl(JavaMailSender javaMailSender) {
		this.mailSender = javaMailSender;
	}
	
	public boolean sendEmail(SimpleMailMessage email) {
		try{
			mailSender.send(email);
			return true;
		}catch(MailException e) {
			return false;
		}
	}
	
	public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("ltinsure.controller@gmail.com");
            message.setTo("rahulghosh8341@gmail.com");
            message.setSubject("Hi");
            message.setText("Testing mail");

            mailSender.send(message);
            
        } catch (MailException exception) {
            exception.printStackTrace();
        }
    }

}

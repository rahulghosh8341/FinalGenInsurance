package com.lti.projectgladiator.ltinsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.projectgladiator.ltinsure.dto.ContactUsDto;
import com.lti.projectgladiator.ltinsure.dto.StatusDto;
import com.lti.projectgladiator.ltinsure.service.EmailService;

@RestController
@CrossOrigin
public class ContactUsController {
	@Autowired
	private EmailService emailService;
	
	@PostMapping(path = "/contactUs", consumes = "application/json", produces = "application/json")
	public StatusDto login(@RequestBody ContactUsDto contactUsDto) {
		try {

			SimpleMailMessage registeredMail = new SimpleMailMessage();
			registeredMail.setFrom(contactUsDto.getEmailId()); // email of sender
			registeredMail.setTo("ghoshrahul876@gmail.com");   //server email address
			registeredMail.setSubject(contactUsDto.getSubject());
			registeredMail.setText(contactUsDto.getMessage());

			emailService.sendEmail(registeredMail);
			
			StatusDto status = new StatusDto();
			status.setMessage("Sent successfully!");
			status.setStatus(StatusDto.StatusType.SUCCESS);
			return status;
		} catch (MailException e) {
			StatusDto status = new StatusDto();
			status.setMessage("Error occured during sending email!");
			status.setStatus(StatusDto.StatusType.FAILURE);
			return status;
		}
	}

}

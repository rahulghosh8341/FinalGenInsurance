package com.lti.projectgladiator.ltinsure.controller;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.projectgladiator.ltinsure.beans.User;
import com.lti.projectgladiator.ltinsure.dto.ForgotDto;
import com.lti.projectgladiator.ltinsure.dto.ForgotPasswordStatus;
import com.lti.projectgladiator.ltinsure.dto.OtpDto;
import com.lti.projectgladiator.ltinsure.dto.StatusDto;
import com.lti.projectgladiator.ltinsure.dto.StatusDto.StatusType;
import com.lti.projectgladiator.ltinsure.dto.UpdateDto;
import com.lti.projectgladiator.ltinsure.exception.UserServiceException;
import com.lti.projectgladiator.ltinsure.service.EmailService;
import com.lti.projectgladiator.ltinsure.service.UserService;

@RestController
@CrossOrigin
public class PasswordController {
	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@PostMapping(path = "/forgotPassword", consumes = "application/json", produces = "application/json")
	public ForgotPasswordStatus forgotPassword(@RequestBody ForgotDto forgotDto) {
		ForgotPasswordStatus status = new ForgotPasswordStatus();
		System.out.println(forgotDto.getEmail());
		User user = userService.getUserByEmail(forgotDto.getEmail());
		
		try {
			if (!userService.isUserPresent(forgotDto.getEmail())) {
				status.setEmail(user.getEmailId());
				status.setMessage("User does not exists!");
				status.setStatus(StatusType.FAILURE);
			}

			String generatedOtp = UserService.generateOtp();
			if (generatedOtp == null) {
				status.setEmail(user.getEmailId());
				status.setMessage("OTP could not generated, try again!");
				status.setStatus(StatusType.FAILURE);
			}

			user.setOtp(generatedOtp);

			userService.addOrUpdateUser(user);

			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("ltinsure.controller@gmail.com"); // email of sender
			passwordResetEmail.setTo(user.getEmailId());
			passwordResetEmail.setSubject("Reset your password");
			passwordResetEmail.setText("Your otp to reset password is " + generatedOtp);

			emailService.sendEmail(passwordResetEmail);

			
			status.setEmail(user.getEmailId());
			status.setMessage("Otp for password reset is send to " + user.getEmailId());
			status.setStatus(StatusType.SUCCESS);

			return status;

		} catch (UserServiceException | NoResultException ex) {
			status.setEmail(user.getEmailId());
			status.setMessage(ex.getMessage());
			status.setStatus(StatusType.FAILURE);

			return status;
		}
	}

	@PostMapping(path = "/verifyOtp", consumes = "application/json", produces = "application/json")
	public StatusDto verifyOtp(@RequestBody OtpDto otpDto) {
		try {
			User user = userService.getUserByOtp(otpDto.getOtp());
			if (user == null) {
				throw new UserServiceException("Invalid token");
			}
			StatusDto status = new StatusDto();
			status.setMessage("Registered successfully!");
			status.setStatus(StatusDto.StatusType.SUCCESS);
			
			return status;

		} catch (UserServiceException e) {
			StatusDto status = new StatusDto();
			status.setMessage(e.getMessage());
			status.setStatus(StatusDto.StatusType.FAILURE);
			return status;
		}
	}
	
	@PostMapping(path = "/updatePassword", consumes = "application/json", produces = "application/json")  // emailId, oldPassword, newPassword
	public StatusDto updatePassword(@RequestBody UpdateDto reset) {
		try {
			User user = userService.getUserByEmail(reset.getEmailId());
			
			if (user == null) {
				throw new UserServiceException("Unknown email address");
			}
			
			user.setPassword(UserService.getHashedString(reset.getNewPassword()));
			user.setOtp(null);
			
			userService.addOrUpdateUser(user);
			
			StatusDto status = new StatusDto();
			status.setMessage("Updated successfully!");
			status.setStatus(StatusDto.StatusType.SUCCESS);
			
			return status;

		} catch (UserServiceException e) {
			StatusDto status = new StatusDto();
			status.setMessage(e.getMessage());
			status.setStatus(StatusDto.StatusType.FAILURE);
			return status;
		}
	}
	
}

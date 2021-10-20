package com.lti.projectgladiator.ltinsure.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.projectgladiator.ltinsure.dto.ErrorResponse;
import com.lti.projectgladiator.ltinsure.dto.LoginDto;
import com.lti.projectgladiator.ltinsure.dto.LoginStatusDto;
import com.lti.projectgladiator.ltinsure.dto.StatusDto;
import com.lti.projectgladiator.ltinsure.exception.UserServiceException;
import com.lti.projectgladiator.ltinsure.service.UserService;

@RestController
@CrossOrigin
public class UserLoginController {

	@Autowired
	private UserService userService;


	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public LoginStatusDto login(@RequestBody LoginDto loginDto) {

		try {
			if (!userService.isUserPresent(loginDto.getEmail())) {
				throw new UserServiceException("User does not exists!");
			}

			List<String> sessionData = userService.login(loginDto.getEmail(), loginDto.getPassword());

			if (sessionData == null) {
				throw new UserServiceException("Incorrect Password!");
			}

			LoginStatusDto status = new LoginStatusDto();
			status.setId(Integer.parseInt(sessionData.get(0)));
			status.setName(sessionData.get(1));
			status.setRole(sessionData.get(2));
			status.setMessage("Login Success");
			status.setStatus(StatusDto.StatusType.SUCCESS);
			return status;

		} catch (Exception e) {
			LoginStatusDto status = new LoginStatusDto();
			status.setId(-1);
			status.setName(null);
			status.setRole(null);
			status.setStatus(StatusDto.StatusType.FAILURE);
			if (e instanceof UserServiceException) {
				//e.printStackTrace();
				status.setMessage(e.getMessage());
			} else {
				//e.printStackTrace();
				status.setMessage(e.getMessage());
			}
			return status;
		}

	}

}

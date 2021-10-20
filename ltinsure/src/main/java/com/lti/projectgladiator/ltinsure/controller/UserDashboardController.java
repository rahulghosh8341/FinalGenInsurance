package com.lti.projectgladiator.ltinsure.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.projectgladiator.ltinsure.beans.Claim;
import com.lti.projectgladiator.ltinsure.beans.Policy;

@RestController
@CrossOrigin
public class UserDashboardController {
	@GetMapping(path = "/getInsurance", produces = "application/json")
	public Policy getInsurance() {
		return null;
	}
	
	@GetMapping(path = "/getClaim", produces = "application/json")
	public Claim getClaimHistory() {
		return null;
	}
}

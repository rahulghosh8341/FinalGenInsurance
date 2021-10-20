package com.lti.projectgladiator.ltinsure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.projectgladiator.ltinsure.beans.Payment;
import com.lti.projectgladiator.ltinsure.dto.PaymentDto;
import com.lti.projectgladiator.ltinsure.exception.MakePaymentException;
import com.lti.projectgladiator.ltinsure.service.PaymentServiceImpl;

@RestController
@CrossOrigin
public class MakePaymentController {
	
	@Autowired
	private PaymentServiceImpl makePaymentService;
	
	@PostMapping(path = "/payment", consumes = "application/json" , produces = "application/json")
	public Payment makePaymentNow(@RequestBody PaymentDto paymentDto) {
		Payment payment = new Payment();
		try {
			payment = makePaymentService.proceedPayment(paymentDto);
		}
		catch(MakePaymentException e) {
			System.out.println(e.getMessage());
		}
		
		return payment;
	}
}

package com.lti.projectgladiator.ltinsure.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.projectgladiator.ltinsure.beans.Customer;
import com.lti.projectgladiator.ltinsure.beans.Payment;
import com.lti.projectgladiator.ltinsure.dao.PaymentDao;
import com.lti.projectgladiator.ltinsure.dto.PaymentDto;
import com.lti.projectgladiator.ltinsure.exception.MakePaymentException;

@Service
public class PaymentServiceImpl implements PaymentService {
		
	@Autowired
	private PaymentDao makePaymentRepository;
	
	@Override
    public Payment proceedPayment(PaymentDto paymentDto) {
        Payment newPayment = new Payment();
        String email = paymentDto.getEmail();
        
        if(makePaymentRepository.isUserValid(email)) {
        	Customer customer = makePaymentRepository.getCustomerByEmail(email);
        	//newPayment.setId(id);
        	newPayment.setAmount(paymentDto.getAmount());
        	newPayment.setDate(LocalDate.now());
        	newPayment.setMode(paymentDto.getModeOfPayment());
        	newPayment.setCustomer(customer);
        	makePaymentRepository.save(newPayment);
        }
        else throw new MakePaymentException("User not Valid. Payment Failed.");
        return newPayment;
    }

}

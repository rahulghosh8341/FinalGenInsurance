package com.lti.projectgladiator.ltinsure.service;

import com.lti.projectgladiator.ltinsure.beans.Payment;
import com.lti.projectgladiator.ltinsure.dto.PaymentDto;

public interface PaymentService {

	Payment proceedPayment(PaymentDto paymentDto);

}
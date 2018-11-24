package com.pms.service;

import org.springframework.http.ResponseEntity;

import com.pms.Entities.Payment;
import com.pms.Entities.PaymentObject;
import com.pms.Entities.PolicyPaymentDisplay;

public interface PaymentServiceInterface {

	ResponseEntity<?> generateBill(PaymentObject obj);

}
package com.pms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Entities.PaymentObject;
import com.pms.Entities.PolicyPaymentDisplay;
import com.pms.service.PaymentService;

@RestController
@CrossOrigin
public class PaymentController {

	@Autowired
	PaymentService paymentservice;
   
	
	@PostMapping(value="/paymentBill/")
	public ResponseEntity<?> PolicyPayment(@RequestBody PaymentObject pob) {
        // @RequestBody LoginObject value   2. value
		// PolicyPaymentDisplay
		ResponseEntity<?>pm=null;
		System.out.println(pob.getPolicy()+" "+pob.getUser());
		 pm=paymentservice.generateBill(pob);
		System.out.println("controller");     
		//return pm;
		return pm ;
	}
	@PostMapping(value="/paymentSucess/")
	public ResponseEntity<?> Finalpayment(@RequestBody PolicyPaymentDisplay ppd) {
        // @RequestBody LoginObject value   2. value
		System.out.println("Hi i am generating bill");
		String ps=null;
		 ps=paymentservice.sucessMsg(ppd);
		System.out.println("controller");     
		//return ps;
		return new ResponseEntity<String>(ps , HttpStatus.OK);
	}

}

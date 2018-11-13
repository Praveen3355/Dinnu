package com.pms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Entities.PolicyTable;
import com.pms.service.Service1;

@RestController
@CrossOrigin
public class PolicyRegistrationController {
	@Autowired
	Service1 simple;
	
	@PostMapping(value="/registeringPolicy/")
	public ResponseEntity<?> newPolicyRegister(@RequestBody PolicyTable policy){
		 System.out.println("vanta");
	    String message = simple.registerPolicy(policy);
	    return new ResponseEntity<String>( message, HttpStatus.OK);
		
	}
	
	

}
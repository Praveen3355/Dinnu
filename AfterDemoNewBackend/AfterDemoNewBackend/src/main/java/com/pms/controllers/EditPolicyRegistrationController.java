package com.pms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Entities.PolicyTable;
import com.pms.service.Service1;


	@RestController
	@CrossOrigin
	public class EditPolicyRegistrationController {
		@Autowired
		Service1 simple;
		
		@PutMapping(value = "/editregisteredPolicy/")
		public ResponseEntity<?> editPolicy(@RequestBody PolicyTable policy){
			
			String msg=simple.editPolicy(policy);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		    
			
		}

}
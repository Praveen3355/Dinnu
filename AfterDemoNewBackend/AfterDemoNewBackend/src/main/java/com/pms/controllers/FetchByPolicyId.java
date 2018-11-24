
package com.pms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Entities.PolicyforEdit;
import com.pms.service.Service1;
@RestController
@CrossOrigin
public class FetchByPolicyId {
	@Autowired
	Service1 simple;
	
	@GetMapping("/returnPolicyId/{policyId}")
	public ResponseEntity<?> findById(@PathVariable("policyId") String policyId)  {
		
	    ResponseEntity<?> policy;	
		
		policy=simple.findById(policyId);
	
		return policy;
	}
}
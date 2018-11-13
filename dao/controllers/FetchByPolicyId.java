
package com.pms.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Entities.PolicyTable;
import com.pms.service.Service1;
@RestController
@CrossOrigin
public class FetchByPolicyId {
	@Autowired
	Service1 simple;
	Optional<PolicyTable> policy=null;

	@GetMapping("/{policyId}")
	public ResponseEntity<?> findById(@PathVariable("policyId") String policyId)  {
		
		
		
		policy=simple.findById(policyId);
		
		if(!policy.isPresent()) {
			
			return new ResponseEntity<String>("Product id "+policyId+"  not registered",HttpStatus.OK);
		}
		
		return new ResponseEntity<Optional<PolicyTable>> (policy, HttpStatus.OK);
	}
}
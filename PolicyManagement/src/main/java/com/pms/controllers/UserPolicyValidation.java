
package com.pms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pms.service.Service1;
@RestController
@CrossOrigin



public class UserPolicyValidation {
	@Autowired
	Service1 simple;
	
	@GetMapping(value = "/{userid}/{policyId}")
public boolean UserPolvalidation(@PathVariable("userid") String userid,@PathVariable("policyId") String policyId)
{
	
	String[] val=policyId.split("-");
	
	int n=simple.findNumber(userid,val[0]);
	if(n==2)
	{
		return false;
	}
	else
		return true;
}
}
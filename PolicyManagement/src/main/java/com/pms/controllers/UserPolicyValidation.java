
package com.pms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.dao.PolicyDataRepo;
import com.pms.service.Service1;
@RestController
@CrossOrigin
@ComponentScans(value = { @ComponentScan("com.cts.product.dao"), @ComponentScan("com.cts.product.service") })
@RequestMapping(value = "/products")

public class UserPolicyValidation {
	@Autowired
	Service1 simple;
	
	
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
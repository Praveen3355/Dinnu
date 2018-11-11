package com.pms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Entities.UserEnrolledPolicy;
import com.pms.service.Service1;

@RestController
@CrossOrigin

public class UserPolicyAmountValidation {
	@Autowired
	Service1 simple;
	public boolean UserAmountValidate(@PathVariable("userid") String userid,@PathVariable("policyId") String policyId)
	{
		List<UserEnrolledPolicy> ueps=simple.findByUserId(userid);
		int sum=0;
		
		for(UserEnrolledPolicy uep:ueps)
		{
			int ta=uep.getPolicy().getTermAmount();
			int tpa=uep.getPolicy().getTermsPerYear();
			sum=sum+ta+tpa;
			
		}
		UserEnrolledPolicy uep=null;
		double annual_income=uep.getUser().getSalary()*12;
		if(sum<=(0.4)*annual_income)
		{
			return true;
			
		}
		else
			return false;
		
	}
	

}

package com.pms.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Entities.MessageObject;
import com.pms.Entities.PolicyReturnObject;
import com.pms.Entities.PolicyTable;
import com.pms.Entities.UserEnrolledPolicy;
import com.pms.service.Service1;

@RestController
@CrossOrigin
public class FetchUserPolicyDetailsByUserId {
	@Autowired
	Service1 simple;
	List<String> policyIds=null;
	MessageObject m=new MessageObject();
	List<PolicyReturnObject> ptl=null;
	@GetMapping("/we/")
	public ResponseEntity<?> FetchUserPolicyDetails(@RequestParam("userid") String Userid){
		// ptl=new ArrayList<PolicyReturnObject>();
		System.out.println(" FetchUserPolicyDetails in for " + Userid );
		List<UserEnrolledPolicy> ueps=null;
		ueps=simple.findByUserId(Userid);
		if(ueps.isEmpty())
		{
			m.setMessage("No subsribed policies are found");
			  System.out.println("------------------------line 37");
				return new ResponseEntity<MessageObject> (m,HttpStatus.OK);
		}
		else {	
		PolicyTable pt=null ;
		PolicyReturnObject pro = new PolicyReturnObject();;
		//List<PolicyTable> lstpt=new ArrayList();
	    policyIds= null;
		policyIds=new ArrayList<>();
		
		System.out.println(ueps.size());
		ptl=new ArrayList<>();
		for(int i=0;i<ueps.size();i++)
		{
			
			
			policyIds.add(i, ueps.get(i).getPolicy().getPolicyId());
			System.out.println(i+"line 50 ");
			System.out.println(policyIds.get(i) +"line 51 ");
			//pt.add(simple.findById(policyIds.get(i)));
			
			pro=new PolicyReturnObject	();
			pro=simple.findById1(policyIds.get(i));
			System.out.println("------ Hashcode: "+pro.hashCode());
			//System.out.println(pt.getCompany().getCompanyName());
		/*	pro.setCompanyName(pt.getCompany().getCompanyName());
			pro.setPolicyName(pt.getPolicyName());
			pro.setTermAmount(pt.getTermAmount());*/
			/*//
		String companyNanme= compdao.findByCompanyName();
		*/
			System.out.println("-------------------line 61");
		System.out.println(pro.getCompanyName());
		System.out.println(pro.getPolicyName());
		System.out.println(pro.getTermAmount());
		System.out.println("--------------------------65");
	    ptl.add(pro);
	    
		System.out.println("FetchUserPolicyDetails out");
		System.out.println("------------------------------------------- line 67");
		/*System.out.println(ptl.get(i).getCompanyName());
		System.out.println(ptl.get(i).getPolicyName());	
		System.out.println(ptl.get(i).getTermAmount());*/
		if(!ptl.isEmpty()) {
			for(int j=0;j<ptl.size();j++) {
				System.out.println(ptl.get(j).getCompanyName());
				System.out.println(ptl.get(j).getPolicyName());
				System.out.println(ptl.get(j).getTermAmount());
			}
		}
		}
		
	
		System.out.println("------------------line 89");
    return new ResponseEntity<List<PolicyReturnObject>> (ptl,HttpStatus.OK);}
	 
	}
	//	return null;}

		
	}


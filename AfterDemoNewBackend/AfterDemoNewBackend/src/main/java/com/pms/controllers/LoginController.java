package com.pms.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Entities.Company;
import com.pms.Entities.LinkMessages;
import com.pms.Entities.LoginObject;
import com.pms.Entities.Mainuser;
import com.pms.Entities.PolicyTable;
import com.pms.service.Service1;
@RestController
@CrossOrigin
@ComponentScans(value = { @ComponentScan("com.pms.dao"), @ComponentScan("com.pms.service") })
public class LoginController {
	@Autowired
    Service1 simple;
	LoginObject value=null;
	@RequestMapping(value="/login/",method=RequestMethod.POST)
	public ResponseEntity<String> loginMethod(HttpServletRequest request,@RequestBody LoginObject value) {
        // @RequestBody LoginObject value   2. value
		String message=simple.authenticate(request,value); 
		System.out.println("controller");     
		//return message;
		return new ResponseEntity<String>(message , HttpStatus.OK);
	}
	
	
/*	@GetMapping("/getPolicyList/")
	public List<PolicyTable> polList(@RequestParam ("userid") String user){
		
		List<PolicyTable> tab=new ArrayList<>();
		System.out.println(user);
		return tab;
		
	}*/
	
	@RequestMapping(value="/register/",method=RequestMethod.POST)
	public ResponseEntity<?> registerMethod1(@RequestBody Mainuser user) {
		 System.out.println("hi gowtham");
		String a=simple.registerUser2(user);
        System.out.println(user.getEmailId());
		return new ResponseEntity<String>(a, HttpStatus.OK);
			}
	@RequestMapping(value="/registernopass/",method=RequestMethod.POST)
	public ResponseEntity<?> registerMethod2(@RequestBody Mainuser user) {
		 System.out.println("hi praveen");
		String a=simple.registerUser1(user);
        System.out.println(user.getEmailId());
		return new ResponseEntity<String>(a, HttpStatus.OK);
			}


	
	@GetMapping("/getCompanyMap/")
	public ResponseEntity<?> companyMap(){
		return new ResponseEntity(simple.selectCompany(),HttpStatus.OK );
	}
	
	List<PolicyTable> policy=null;
	LinkMessages obj1=null;
	
	@GetMapping("/searchRecent/")
	public ResponseEntity<?> sortRecentPolicies()  {
		
		
		policy=new ArrayList<>();
		obj1=new LinkMessages();
		policy=simple.sortRecentService();
		
		
		obj1.setMessage1(policy.get(0).getPolicyName() + " by " + policy.get(0).getCompany().getCompanyName());
		obj1.setMessage2(policy.get(1).getPolicyName() + " by " + policy.get(1).getCompany().getCompanyName());
		obj1.setMessage3(policy.get(2).getPolicyName() + " by " + policy.get(2).getCompany().getCompanyName());
		obj1.setMessage4(policy.get(3).getPolicyName() + " by " + policy.get(3).getCompany().getCompanyName());
		
		return new ResponseEntity<LinkMessages> (obj1, HttpStatus.OK);
	}
	
}

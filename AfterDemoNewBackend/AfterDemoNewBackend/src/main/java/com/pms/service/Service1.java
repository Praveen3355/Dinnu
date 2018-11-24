package com.pms.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;

import com.pms.Entities.LoginObject;
import com.pms.Entities.Mainuser;
import com.pms.Entities.PolicyReturnObject;
import com.pms.Entities.PolicyTable;
import com.pms.Entities.SearchReturn;
import com.pms.Entities.UserEnrolledPolicy;

public interface Service1 {

  //  String authenticate(LoginObject log);
    String registerUser1(Mainuser user);
    String registerUser2(Mainuser user);
    String registerPolicy(PolicyTable obj);
	//String authenticate();
	int findNumber(String userid, String var);
	ResponseEntity<?> findById(String policyId);
	List<UserEnrolledPolicy> findByUserId(String userid);
	/*String save(PolicyTable policy);*/
	String editPolicy(PolicyTable policy);
	List<SearchReturn> searchPolicy(String companyName,int years,String policyType,String policyName);
	String authenticate(HttpServletRequest request, LoginObject log);
	PolicyReturnObject findById1(String policy);
	List<Map<String,String>> selectCompany();
	List<PolicyTable> sortRecentService();
	
}
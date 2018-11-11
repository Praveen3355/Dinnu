package com.pms.service;

import java.util.List;
import java.util.Optional;

import com.pms.Entities.LoginObject;
import com.pms.Entities.Mainuser;
import com.pms.Entities.PolicyTable;
import com.pms.Entities.UserEnrolledPolicy;

public interface Service1 {

    String authenticate(LoginObject log);
    String registerUser(Mainuser user);
    String registerPolicy(PolicyTable obj);
    public String save(PolicyTable policy);
    public  Optional<PolicyTable> findById(String policyId);
    public int findNumber(String userid,String var);
    public List<UserEnrolledPolicy> findByUserId(String userid);

}
package com.pms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.Entities.PolicyTable;
import com.pms.Entities.UserEnrolledPolicy;

@Repository
public interface PolicyDataRepo  extends JpaRepository<PolicyTable, String>  {

  
    //public List<Mainuser> findByIdEquals(String a);
    
    @Query("select pt from PolicyTable pt where pt.policyType = :policy order by pt.policyId DESC limit 1 ")
    public PolicyTable findByPolicyType(@Param ("policy") String userid);
    @Query("select count(uep.policy_policy_id) from UserEnrolledPolicy uep where uep.user_user_id=userid and uep.policy_policy_id like %:var% ")
    public int findNumber(@Param ("userid") String userid, @Param("var") String var);
    @Query("select uep from UserEnrolledPolicy uep where uep.user_user_id=userid")
    public List<UserEnrolledPolicy> findByUserId(@Param ("userid") String userid);
    
    
    
    

    
	

}


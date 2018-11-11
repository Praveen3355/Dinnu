package com.pms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.Entities.PolicyTable;

@Repository
public interface PolicyDataRepo  extends JpaRepository<PolicyTable, String>  {

  
    //public List<Mainuser> findByIdEquals(String a);
    
    @Query("select pt from PolicyTable pt where pt.policyType = :policy order by pt.policyId DESC limit 1 ")
    public PolicyTable findByPolicyType(@Param ("policy") String userid);
    @Query("select count(uep.policyId) from UserEnrolledPolicy uep where uep.userid=userid and uep.policyId like %:var% ")
    public int findNumber(@Param ("userid") String userid, @Param("var") String var);
    
    
    

    
	

}


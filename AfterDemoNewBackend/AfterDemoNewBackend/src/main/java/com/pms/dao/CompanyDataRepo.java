package com.pms.dao;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.pms.Entities.Company;

@Repository
public interface CompanyDataRepo extends JpaRepository<Company,String> {

	
	@Query(value ="select * from company c",nativeQuery=true)
	public List<Map<String,String>> selectCustomer(); 
	
}

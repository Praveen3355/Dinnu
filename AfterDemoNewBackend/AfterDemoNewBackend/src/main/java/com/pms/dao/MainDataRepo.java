package com.pms.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pms.Entities.Mainuser;

@Repository
public interface MainDataRepo  extends JpaRepository<Mainuser, String>  {

  
    //public List<Mainuser> findByIdEquals(String a);
    
    @Query("select mu from Mainuser mu where mu.userid like :userid ")
    public Mainuser findByName(@Param ("userid") String userid);
    
    @Query("select me from Mainuser me where me.panNo = :pan or me.emailId= :mail")
    public List<Mainuser> findByPanNoOrEmaiId(@Param ("pan") String pan,@Param ("mail") String email);
   
 
    public List<Mainuser> findByUseridStartingWithOrderByUseridDesc(String a );
    
    @Query(value="select * from mainuser m where m.user_id=:userid",nativeQuery=true)
	 public Mainuser findByUserid(String userid);

}

/*

package com.cts.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cts.entities.User;


@Repository("dao")
@Component
public interface Dao extends JpaRepository<User, String>{
	
	@Query("select mu.first_name from mainuser mu where mu.user_id= userid and mu.pass=password")
	String findByName(String userid,String password);

}
*/
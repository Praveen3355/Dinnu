package com.pms.dao;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pms.Entities.*;
@Repository
public interface PaymentAcessDao  extends JpaRepository<com.pms.Entities.Payment,String>  {

	/*@Query("select prod.prodId,prod.prodName,prod.price"
			+ " from Product prod where prod.prodName like %:name%")
	List<Product>findByName(@Param("name") String name);*/
@Query(value="select * from Payment pay where pay.user_user_id = :user and pay.bill_id like :policy% order by pay.bill_date desc LIMIT 1 ",nativeQuery=true)
	Payment findByName(@Param("user")String user, @Param("policy")String policy);

@Query(value="select bill_id from Payment pay order by id desc LIMIT 1 ",nativeQuery=true)
String findLatestBill();


/*@Query("insert into payment p values(ps.BillId,ppd.CurrentDate,ppd.Amount,ppd.fine,ppd.DueDate,ppd.UserId")
void insertNewBill(PolicyPaymentDisplay ppd, PaymentSucess ps);*/

/*@Query("insert into Payment (Bill_Date,Bill_Id,Due_Date,Fine,Paid_Amt,user) select :billDate,:BillId,:Duedate,:Fine,:PaidAmt,:user from Payment")
public int insertNewBill(@Param("billDate")LocalDate billDate, @Param("BillId")String BillId, @Param("Duedate")LocalDate Duedate,@Param("Fine")double Fine,@Param("PaidAmt")double PaidAmt,@Param("user")Optional<Mainuser> user);
@Modifying
@Transactional
@Query(value="insert into payment p values(")
public int insertNewBill(@Param("billDate")LocalDate billDate, @Param("BillId")String BillId, @Param("Duedate")LocalDate Duedate,@Param("Fine")double Fine,@Param("PaidAmt")double PaidAmt,@Param("user")Optional<Mainuser> user);*/



}
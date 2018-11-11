package com.pms.Entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Payment")
public class Payment {
	@Id
	@Column(name="bill_id")
	private String billId;
	@Column(name="bill_date")
	private Date billDate;
	@Column(name="paid_amt")
	private double paidAmt;
	@Column(name="fine")
	private double fine;
	@Column(name="due_date")
	private double dueDate;
	@ManyToOne
	private Mainuser user;
	
	
	public String getBillId() {
		return billId;
	}
	public void setBillId(String billId) {
		this.billId = billId;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public double getPaidAmt() {
		return paidAmt;
	}
	public void setPaidAmt(double paidAmt) {
		this.paidAmt = paidAmt;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public double getDueDate() {
		return dueDate;
	}
	public void setDueDate(double dueDate) {
		this.dueDate = dueDate;
	}
	public Mainuser getUser() {
		return user;
	}
	public void setUser(Mainuser user) {
		this.user = user;
	}
	
	
}

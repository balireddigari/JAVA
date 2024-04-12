package com.PolicyManagement.Model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

 
@Entity

public class PremiumPayment{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date paymentDate;
    private String bankTransactionId;
    private Float premiumAmount;
    private Float lateFee;
 
    @ManyToOne
    @JoinColumn(name = "PaymentMethodId", referencedColumnName = "id")
    private PaymentMethods paymentMethod;
 
    @ManyToOne
    @JoinColumn(name = "PremiumMasterId", referencedColumnName = "id")
    private PremiumMaster premiumMaster;



	public PremiumPayment() {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date date) {
		this.paymentDate = date;
	}

	public String getBankTransactionId() {
		return bankTransactionId;
	}

	public void setBankTransactionId(String bankTransactionId) {
		this.bankTransactionId = bankTransactionId;
	}

	public Float getPremiumAmount() {
		return premiumAmount;
	}

	public void setPremiumAmount(Float premiumAmount) {
		this.premiumAmount = premiumAmount;
	}

	public Float getLateFee() {
		return lateFee;
	}

	public void setLateFee(Float lateFee) {
		this.lateFee = lateFee;
	}

	public PaymentMethods getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethods paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public PremiumMaster getPremiumMaster() {
		return premiumMaster;
	}

	public void setPremiumMaster(PremiumMaster premiumMaster) {
		this.premiumMaster = premiumMaster;
	}
    
 
    // Getters and setters, constructors, etc.
}
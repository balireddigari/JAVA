package com.PolicyManagement.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;


@Entity

public class PaymentMethods {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
 
    private String paymentMethod;

	
	public PaymentMethods() {
		// TODO Auto-generated constructor stub
	}

	public PaymentMethods(int i, String string) {
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
 
    // Getters and setters, constructors, etc.
}
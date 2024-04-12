package com.PolicyManagement.Model;

import java.sql.Date;
import java.util.Collection;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;

@Entity

public class PremiumMaster {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer policyId;
    private String username;
    private Integer subscriptionId;
    private Float premiumAmount;
    private Integer totalNumberOfPremiums;
    private String currentPolicyStatus;
    private Date lastPaymentDate;
    
   
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPolicyId() {
		return policyId;
	}
	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(Integer subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	public Float getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(Float premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	public Integer getTotalNumberOfPremiums() {
		return totalNumberOfPremiums;
	}
	public void setTotalNumberOfPremiums(Integer totalNumberOfPremiums) {
		this.totalNumberOfPremiums = totalNumberOfPremiums;
	}
	public String getCurrentPolicyStatus() {
		return currentPolicyStatus;
	}
	public void setCurrentPolicyStatus(String currentPolicyStatus) {
		this.currentPolicyStatus = currentPolicyStatus;
	}
	public Date getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(Date lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
	
	 
		public PremiumMaster() {
			// TODO Auto-generated constructor stub
		}
		public PremiumMaster(int i, int j, String string, int k, float f, int l, String string2, Date date, Date date2) {
			// TODO Auto-generated constructor stub
		}
	
	
	

}
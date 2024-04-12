
package com.PolicyManagement.Service;

import java.util.Date;
import java.util.List;

import com.PolicyManagement.Model.PremiumPayment;
 
public interface PremiumPaymentService {
 
	List<PremiumPayment> getPremiumPaymentsSubscription(String username, int subscriptionId);
 
    PremiumPayment addNewPremiumPayment(PremiumPayment premiumPayment);
    
	Float calculateLateFee(Integer premiumMasterId);

	Float getLateFeeById(Integer id);

}
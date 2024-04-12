package com.PolicyManagement.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

//import com.PolicyManagement.Model.PaymentMethods;
import com.PolicyManagement.Model.PremiumMaster;
import com.PolicyManagement.Model.PremiumPayment;

public interface PremiumMasterService {
    
	
	PremiumMaster addNewPremiumMaster(PremiumMaster premiumMaster);
	List<PremiumMaster> getDuePaymentUserDetails();
	Optional<PremiumMaster> getMaster(int id);
	
}
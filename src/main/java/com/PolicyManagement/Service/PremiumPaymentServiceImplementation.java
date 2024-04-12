package com.PolicyManagement.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PolicyManagement.Model.PremiumMaster;
import com.PolicyManagement.Model.PremiumPayment;
import com.PolicyManagement.Repository.PremiumMasterRepository;
import com.PolicyManagement.Repository.PremiumPaymentRepository;
import com.PolicyManagement.exception.PolicyMaturedException;

//import com.PolicyManagement.Model.PremiumMaster;
////import com.PolicyManagement.Model.PremiumMaster;
//import com.PolicyManagement.Model.PremiumPayment;
//import com.PolicyManagement.Repository.PremiumMasterRepository;
//import com.PolicyManagement.Repository.PremiumPaymentRepository;
//import com.PolicyManagement.exception.PolicyMaturedException;
//import com.github.andrewoma.dexx.collection.ArrayList;

//import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
//import java.util.stream.Collectors;
 
@Service
public class PremiumPaymentServiceImplementation implements PremiumPaymentService {
 
    private final PremiumPaymentRepository premiumPaymentRepository;
    
    private final PremiumMasterRepository premiumMasterRepository;
 
    @Autowired
    public PremiumPaymentServiceImplementation(PremiumPaymentRepository premiumPaymentRepository, PremiumMasterRepository premiumMasterRepository) {
        this.premiumPaymentRepository = premiumPaymentRepository;
		this.premiumMasterRepository = premiumMasterRepository;
		
    }
    
    @Override
	public List<PremiumPayment> getPremiumPaymentsSubscription(String username, int subscriptionId) {
		// TODO Auto-generated method stub
		return premiumPaymentRepository.getPremiumPaymentsSubscription(username, subscriptionId);
	}
    

    @Override
    public PremiumPayment addNewPremiumPayment(PremiumPayment premiumPayment) throws RuntimeException {
    	
        PremiumMaster premiumMaster = premiumMasterRepository.findById(premiumPayment.getPremiumMaster().getId())
                .orElseThrow(() -> new RuntimeException("Premium Master not found"));
        
        int totalNoofPremiums = premiumMaster.getTotalNumberOfPremiums();
        List<PremiumPayment> premiumPaymentsList = premiumPaymentRepository.findByPremiumMaster(premiumMaster);
        int existingPremiumPayments = premiumPaymentsList.size();

        if (existingPremiumPayments >= totalNoofPremiums) {
            throw new PolicyMaturedException("Total number of premium payments completed");
        }
        
        if (existingPremiumPayments + 1 == totalNoofPremiums) {
            // Update the status of the policy to "Matured"
            premiumMaster.setCurrentPolicyStatus("Matured");
           premiumMasterRepository.save(premiumMaster);
       }
        
        
     // Check if payment is late (after 5th of the month)
        if (isLatePayment(premiumPayment.getPaymentDate())) {
            // Calculate late fee
            float lateFee = calculateLateFee(premiumMaster.getPremiumAmount(), premiumPayment.getPaymentDate());
            premiumPayment.setLateFee(lateFee);
        }

        premiumPaymentRepository.save(premiumPayment);
        return premiumPayment;
         
    }


    private boolean isLatePayment(Date paymentDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(paymentDate);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        return dayOfMonth > 5;
    }
    
    
    private float calculateLateFee(float premiumAmount, Date paymentDate) {
        // Calculate late fee percentage per day (0.025% per day)
        double lateFeePercentagePerDay = 2.5 / 100;
        // Calculate the number of days late
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(paymentDate);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int daysLate = dayOfMonth - 5; // Assuming late if payment is made after the 5th of the month
        // Calculate the late fee
        double lateFee = premiumAmount * lateFeePercentagePerDay * daysLate;
        return (float) lateFee;
    }


    @Override
    public Float getLateFeeById(Integer id) {
        return premiumPaymentRepository.findLateFeeById(id);
    }

	@Override
	public Float calculateLateFee(Integer premiumMasterId) {
		// TODO Auto-generated method stub
		return null;
	}

	

	
	
    }

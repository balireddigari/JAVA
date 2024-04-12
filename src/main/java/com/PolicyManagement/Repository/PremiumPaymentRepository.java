package com.PolicyManagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.PolicyManagement.Model.PremiumMaster;
import com.PolicyManagement.Model.PremiumPayment;

import java.util.Date;
import java.util.List;


     
    @Repository
    public interface PremiumPaymentRepository extends JpaRepository<PremiumPayment, Integer> {
	
    	@Query("SELECT p FROM PremiumPayment p WHERE p.premiumMaster.subscriptionId = :subscriptionId")
        List<PremiumPayment> findPremiumPaymentsForUsernameAndSubscriptionId(@Param("subscriptionId") Integer subscriptionId);

     
        @Query("SELECT p FROM PremiumPayment p WHERE p.paymentDate < :currentDate AND p.lateFee > :lateFeeThreshold")
        List<PremiumPayment> findDuePayments(Date currentDate, Float lateFeeThreshold);
        
        @Query(value = "select pp from PremiumPayment pp inner join PremiumMaster pm on pp.premiumMaster.Id=pm.Id where username=:username and subscriptionId= :subscriptionId")
    	List<PremiumPayment> getPremiumPaymentsSubscription(String username, int subscriptionId);
        
     // Custom query to retrieve late fee from PremiumPayment table
        @Query("SELECT p.lateFee FROM PremiumPayment p WHERE p.id = :id")
        Float findLateFeeById(@Param("id") Integer id);
        
        List<PremiumPayment>findAll();
		Integer countByPremiumMasterId(Integer premiumMasterId);

		List<PremiumPayment> findByPremiumMaster(PremiumMaster premiumMaster);

     
        // Add more custom queries as needed
    }
    
    
    
    
    
//  @Query("SELECT p FROM PremiumPayment p WHERE p.premiumMaster.id = :premiumMasterId")
//  List<PremiumPayment> findPaymentsBySubscriptionId(Integer premiumMasterId);

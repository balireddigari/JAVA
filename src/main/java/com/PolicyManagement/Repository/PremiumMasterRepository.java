package com.PolicyManagement.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.PolicyManagement.Model.PaymentMethods;
import com.PolicyManagement.Model.PremiumMaster;

//import java.util.List;
 

@Repository
public interface PremiumMasterRepository extends JpaRepository<PremiumMaster, Integer> {

	List<PremiumMaster> findById(PremiumMaster premiumMaster);
	
	@Query(value = "select pm from PremiumMaster pm where (day(pm.lastPaymentDate)>10 and month(pm.lastPaymentDate)<month(curdate()) and year(pm.lastPaymentDate) = year(curdate())) or (day(pm.lastPaymentDate)<10 and month(pm.lastPaymentDate)>=month(curdate()) and year(pm.lastPaymentDate) < year(curdate())) or (day(pm.lastPaymentDate)>10 and month(pm.lastPaymentDate)>=month(curdate()) and year(pm.lastPaymentDate) < year(curdate())) ")
	List<PremiumMaster> getDuePaymentUserDetails();
   
}
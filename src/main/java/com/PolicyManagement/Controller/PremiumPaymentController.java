package com.PolicyManagement.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import com.PolicyManagement.Model.PremiumMaster;
import com.PolicyManagement.Model.PremiumPayment;
import com.PolicyManagement.Service.PremiumPaymentService;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/premium-payments")
public class PremiumPaymentController {

   private final PremiumPaymentService premiumPaymentService;

   @Autowired
   public PremiumPaymentController(PremiumPaymentService premiumPaymentService) {
       this.premiumPaymentService = premiumPaymentService;
   }


   @PostMapping("/add")
   public PremiumPayment addNewPremiumPayment(@RequestBody PremiumPayment premiumPayment) {
       return premiumPaymentService.addNewPremiumPayment(premiumPayment);
       
   }
  

       @GetMapping("/subscription/{username}/{subscriptionId}")
   	public ResponseEntity<List<PremiumPayment>> getPremiumPaymentsForSubscription(@PathVariable String username,
   			@PathVariable int subscriptionId) {
   		List<PremiumPayment> subscriptionList = premiumPaymentService.getPremiumPaymentsSubscription(username, subscriptionId);
   		if (!subscriptionList.isEmpty()) {
   			return new ResponseEntity<>(subscriptionList, HttpStatus.OK);
   		} else {
   			return new ResponseEntity<>(Collections.emptyList(), HttpStatus.OK);
   		}
   	}
   
   
       @GetMapping("/late-fee/{id}")
       public Float getLateFeeById(@PathVariable Integer id) {
           return premiumPaymentService.getLateFeeById(id);
       }  
   
   
   
   
   
       
       
       
       
   
   
//   @GetMapping("/check")
//   public String check() {
//   	return "Hello Gayatri";
//   }
//   
//   @GetMapping("/all")
//   public List<PremiumPayment> getBankTransactionId() {
//       return premiumPaymentService.getBankTransactionId();
//   }
}
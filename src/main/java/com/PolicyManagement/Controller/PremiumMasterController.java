package com.PolicyManagement.Controller;

//import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.apache.hc.core5.http.HttpStatus;
//import org.apache.hc.core5.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.ServerRequest.Headers;

import com.PolicyManagement.Model.PremiumMaster;
//import com.PolicyManagement.Model.PremiumPayment;
import com.PolicyManagement.Service.PremiumMasterService;

@RestController
@RequestMapping("/api")
public class PremiumMasterController {
 
   
    @Autowired
    private PremiumMasterService premiumMasterService;

    
    @PostMapping("/premium-masters/add")
    public PremiumMaster addNewPremiumPayment(@RequestBody PremiumMaster premiumMaster) {
        return premiumMasterService.addNewPremiumMaster(premiumMaster);
        
    }
    
    @GetMapping("/getId/{id}")
    public ResponseEntity<?> getPremiumMasterId(@PathVariable int id) {
        Optional<PremiumMaster> master = premiumMasterService.getMaster(id);
        if (master.isPresent()) {
            return ResponseEntity.ok(master.get());
        } else {
            return ResponseEntity.status(HttpStatus.SC_NOT_FOUND).body("PremiumMaster with ID " + id + " not found");
        }
    }
    
    @GetMapping("/premium-masters/dues")
	public ResponseEntity<List<PremiumMaster>> getDueUsers() {
		List<PremiumMaster> dueList = premiumMasterService.getDuePaymentUserDetails();
		 if (!dueList.isEmpty()) {
			 return ResponseEntity.ok(dueList);
		        
		    } else {
		    	return  ResponseEntity.ok(Collections.emptyList());
            }
    }
}
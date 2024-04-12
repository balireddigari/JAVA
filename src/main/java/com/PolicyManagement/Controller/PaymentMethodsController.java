package com.PolicyManagement.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.PolicyManagement.Model.PaymentMethods;
import com.PolicyManagement.Service.PaymentMethodsService;

import java.util.List;
 
@RestController
@RequestMapping("/api")
public class PaymentMethodsController {
 
    @Autowired
    private PaymentMethodsService paymentMethodsService;

    @GetMapping("/payment-methods")
    public List<PaymentMethods> getAllPaymentMethods() {
        return paymentMethodsService.getPaymentMethods();
    }
    
//    @GetMapping("/check")
//    public String check() {
//    	return "Hello Gayatri";
//    }
// 
    // Other methods...
 
}

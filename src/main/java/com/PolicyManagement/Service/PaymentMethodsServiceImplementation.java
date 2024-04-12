package com.PolicyManagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PolicyManagement.Model.PaymentMethods;
import com.PolicyManagement.Repository.PaymentMethodsRepository;

import java.util.List;
 
@Service
public class PaymentMethodsServiceImplementation implements PaymentMethodsService {
 
    private final PaymentMethodsRepository paymentMethodsRepository;
 
    @Autowired
    public PaymentMethodsServiceImplementation(PaymentMethodsRepository paymentMethodsRepository) {
        this.paymentMethodsRepository = paymentMethodsRepository;
    }
 
    @Override
    public List<PaymentMethods> getPaymentMethods() {
        return paymentMethodsRepository.findAll();
    }
}
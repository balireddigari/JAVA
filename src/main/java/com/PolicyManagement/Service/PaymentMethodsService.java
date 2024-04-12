package com.PolicyManagement.Service;


import java.util.List;

import com.PolicyManagement.Model.PaymentMethods;

public interface PaymentMethodsService {
    List<PaymentMethods> getPaymentMethods();
}
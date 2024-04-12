package com.PolicyManagement.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.PolicyManagement.Model.PaymentMethods;

import java.util.List;
 
@Repository
public interface PaymentMethodsRepository extends JpaRepository<PaymentMethods, Integer> {
    // Operation: Return list of payment methods
    List<PaymentMethods> findAll();
}
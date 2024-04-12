package com.PolicyManagement.Service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.PolicyManagement.Model.PaymentMethods;
import com.PolicyManagement.Model.PremiumMaster;
import com.PolicyManagement.Model.PremiumPayment;
import com.PolicyManagement.Repository.PremiumMasterRepository;
import com.PolicyManagement.Repository.PremiumPaymentRepository;

import antlr.collections.List;

//@ExtendWith(MockitoExtension.class)

@RunWith(SpringRunner.class)
@SpringBootTest
public class PremiumPaymentServiceTest {

    @MockBean
    private PremiumPaymentRepository premiumPaymentRepository;

    @MockBean
    private PremiumMasterRepository premiumMasterRepository;

    @Autowired
    private PremiumPaymentService premiumPaymentService;

    @Test
    public void testGetLateFeeById() {
        // Arrange
        Integer paymentId = 1;
        Float expectedLateFee = 50.0f; // Change this to the expected value

        when(premiumPaymentRepository.findLateFeeById(paymentId)).thenReturn(expectedLateFee);

        // Act
        Float actualLateFee = premiumPaymentService.getLateFeeById(paymentId);

        // Assert
        assertEquals(expectedLateFee, actualLateFee);
    }
    
    @Test
    public void testGetPremiumPaymentsSubscription() {
        // Arrange
        String username = "testUser";
        int subscriptionId = 123;
        PremiumPayment premiumPayment1 = new PremiumPayment();
        // Set premium payment properties
        PremiumPayment premiumPayment2 = new PremiumPayment();
        // Set premium payment properties
        java.util.List<PremiumPayment> expectedPremiumPayments = Arrays.asList(premiumPayment1, premiumPayment2);
 
        when(premiumPaymentRepository.getPremiumPaymentsSubscription(username, subscriptionId)).thenReturn(expectedPremiumPayments);
 
        // Act
        java.util.List<PremiumPayment> actualPremiumPayments = premiumPaymentService.getPremiumPaymentsSubscription(username, subscriptionId);
 
        // Assert
        assertEquals(expectedPremiumPayments, actualPremiumPayments);
    }


    @Test
    public void testAddNewPremiumPayment() {
        // Arrange
        PremiumMaster premiumMaster = new PremiumMaster();
        premiumMaster.setId(1); // Assuming premium master exists with ID 1
        premiumMaster.setTotalNumberOfPremiums(5); // Assuming total number of premiums is 5
        premiumMaster.setCurrentPolicyStatus("Matured"); // Assuming policy status is initially "Active"
        premiumMaster.setPremiumAmount((float) 1000);
        
        PaymentMethods paymentMethods = new PaymentMethods();
        PremiumPayment premiumPayment = new PremiumPayment();
        premiumPayment.setId(1); // Assuming premium payment ID
        premiumPayment.setPremiumMaster(premiumMaster);
        premiumPayment.setPremiumAmount(premiumPayment.getPremiumMaster().getPremiumAmount());
        premiumPayment.setPaymentDate(new Date());
        
        when(premiumMasterRepository.findById(1)).thenReturn(Optional.of(premiumMaster));
        when(premiumPaymentRepository.findByPremiumMaster(premiumMaster)).thenReturn(Arrays.asList(premiumPayment));
        when(premiumPaymentRepository.save(premiumPayment)).thenReturn(premiumPayment);
 
        // Act
        PremiumPayment savedPremiumPayment = premiumPaymentService.addNewPremiumPayment(premiumPayment);
 
        // Assert
        assertEquals(premiumPayment, savedPremiumPayment);
        assertEquals("Matured", premiumMaster.getCurrentPolicyStatus()); // Policy status should be "Matured"
        verify(premiumMasterRepository, times(1)).findById(1);
        verify(premiumPaymentRepository, times(1)).findByPremiumMaster(premiumMaster);
        verify(premiumPaymentRepository, times(1)).save(premiumPayment);
    }
    
      
    
    
    
    
}

    

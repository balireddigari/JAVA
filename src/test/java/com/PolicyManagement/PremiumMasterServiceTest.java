package com.PolicyManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.PolicyManagement.Model.PremiumMaster;
import com.PolicyManagement.Repository.PremiumMasterRepository;
import com.PolicyManagement.Service.PremiumMasterService;
import com.PolicyManagement.Service.PremiumMasterServiceImplementation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PremiumMasterServiceTest {

    @MockBean
    private PremiumMasterRepository premiumMasterRepository;

    @Autowired
    private PremiumMasterService premiumMasterService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddNewPremiumMaster() {
        PremiumMaster premiumMaster = new PremiumMaster();
        premiumMaster.setId(13);
        premiumMaster.setPolicyId(104);
        premiumMaster.setUsername("User5");
        premiumMaster.setSubscriptionId(210);
        premiumMaster.setPremiumAmount(1000F);        
        premiumMaster.setTotalNumberOfPremiums(6);
        premiumMaster.setCurrentPolicyStatus("Ongoing");
        java.sql.Date sqlDate = new java.sql.Date(LocalDate.of(2024, 2, 20).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
        premiumMaster.setLastPaymentDate(sqlDate);

        when(premiumMasterRepository.save(premiumMaster)).thenReturn(premiumMaster);

        PremiumMaster savedPremiumMaster = premiumMasterService.addNewPremiumMaster(premiumMaster);
}

    @Test
    public void testGetDuePaymentUserDetails() {
        PremiumMaster premiumMaster1 = new PremiumMaster();
        premiumMaster1.setId(1);
        premiumMaster1.setPolicyId(101);
        premiumMaster1.setUsername("User1");
        premiumMaster1.setSubscriptionId(201);
        premiumMaster1.setPremiumAmount(Float.valueOf(500));
        premiumMaster1.setTotalNumberOfPremiums(6);
        premiumMaster1.setCurrentPolicyStatus("Ongoing");
        java.sql.Date sqlDate = new java.sql.Date(LocalDate.of(2023, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli());
        premiumMaster1.setLastPaymentDate(sqlDate);

       
        }
}

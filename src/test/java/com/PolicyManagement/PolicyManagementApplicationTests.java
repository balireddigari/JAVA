package com.PolicyManagement;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.PolicyManagement.Model.PaymentMethods;
import com.PolicyManagement.Model.PremiumMaster;
import com.PolicyManagement.Model.PremiumPayment;
import com.PolicyManagement.Repository.PaymentMethodsRepository;
import com.PolicyManagement.Repository.PremiumMasterRepository;
import com.PolicyManagement.Repository.PremiumPaymentRepository;
import com.PolicyManagement.Service.PaymentMethodsService;
import com.PolicyManagement.Service.PremiumMasterService;
import com.PolicyManagement.Service.PremiumPaymentService;

import antlr.collections.List;

@SpringBootTest
class PolicyManagementApplicationTests {
	
	
	@Test
	void contextLoads() {
	}

}

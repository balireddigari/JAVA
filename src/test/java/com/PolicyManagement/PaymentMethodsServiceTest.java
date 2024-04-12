package com.PolicyManagement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

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

import com.PolicyManagement.Model.PaymentMethods;
import com.PolicyManagement.Repository.PaymentMethodsRepository;
import com.PolicyManagement.Service.PaymentMethodsService;
import com.PolicyManagement.Service.PaymentMethodsServiceImplementation;

//@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class PaymentMethodsServiceTest {
	
	@Autowired
    private PaymentMethodsService paymentMethodsService;

    @MockBean
    private PaymentMethodsRepository paymentMethodsRepository;

    private List<PaymentMethods> paymentMethodsList;

    @SuppressWarnings("deprecation")
	@BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        paymentMethodsService = new PaymentMethodsServiceImplementation(paymentMethodsRepository);
    }

    @Test
    public void getPaymentMethods_Success() {
        List<PaymentMethods> paymentMethodsList = Arrays.asList(
                new PaymentMethods(),
                new PaymentMethods(),
                new PaymentMethods()
        );

        when(paymentMethodsRepository.findAll()).thenReturn(paymentMethodsList);
        List<PaymentMethods> paymentMethods = paymentMethodsService.getPaymentMethods();
        assertEquals(3, paymentMethods.size());
    }
}

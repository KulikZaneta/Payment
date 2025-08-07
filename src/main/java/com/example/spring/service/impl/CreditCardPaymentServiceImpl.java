package com.example.spring.service.impl;

import com.example.spring.service.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("creditCardPaymentService")
public class CreditCardPaymentServiceImpl implements PaymentService {

    @Override
    public void pay() {
        System.out.println("Paid with Credit Card");
    }
}


package com.example.spring.service.impl;

import com.example.spring.dto.CustomerDto;
import com.example.spring.exception.CustomerNotFoundException;
import com.example.spring.service.CustomerService;
import com.example.spring.service.PaymentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final PaymentService paymentService;

    public CustomerServiceImpl(@Qualifier("creditCardPaymentService") PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    private final Map<Long, String> customerData = Map.of(
            1L, "Anna",
            2L, "Bartek",
            3L, "Celina"
    );

    @Override
    public String getCustomerNameById(Long id) throws CustomerNotFoundException {
        String name = customerData.get(id);
        if (name == null) {
            throw new CustomerNotFoundException("Customer with id " + id + " not found");
        }
        return name;
    }

    @Override
    public void processPayment() {
        paymentService.pay();
    }

    @Override
    public List<CustomerDto> findByNameContaining(String name) {
        return customerData.entrySet().stream()
                .filter(entry -> entry.getValue().toLowerCase().contains(name.toLowerCase()))
                .map(entry -> new CustomerDto(entry.getKey(), entry.getValue()))
                .toList();
    }
}


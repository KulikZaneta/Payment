package com.example.spring.service;

import com.example.spring.dto.CustomerDto;
import com.example.spring.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerService {

    String getCustomerNameById(Long id) throws CustomerNotFoundException;

    void processPayment();

    List<CustomerDto> findByNameContaining(String name);
}

package com.example.spring.controller;

import com.example.spring.dto.CustomerDto;
import com.example.spring.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long id) {
        String name = customerService.getCustomerNameById(id);
        CustomerDto customerDto = new CustomerDto(id, name);
        return ResponseEntity.ok(customerDto);
    }

    @PostMapping("/pay")
    public ResponseEntity<String> makePayment() {
        customerService.processPayment();
        return ResponseEntity.ok("Payment processed");
    }

    @GetMapping("/search")
    public ResponseEntity<List<CustomerDto>> getSearchByName(@RequestParam String name) {
        List<CustomerDto> byNameContaining = customerService.findByNameContaining(name);
        return ResponseEntity.ok(byNameContaining);
    }
}


package com.yener.customerservice.controller;

import com.yener.customerservice.dto.customer.*;
import com.yener.customerservice.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<CreateCustomerResponseDTO> createCustomer(@RequestBody CreateCustomerRequestDTO createCustomerRequestDTO) {
        return ResponseEntity.ok(customerService.createCustomer(createCustomerRequestDTO));
    }

    @GetMapping("/getAllCustomer")
    public ResponseEntity<GetAllCustomerResponseDTO> getAllCustomer() {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @GetMapping("/getCustomerById/{id}")
    public ResponseEntity<GetCustomerResponseDTO> getCustomerById(@PathVariable("id") Long customerId) {
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<DeleteCustomerResponseDTO> deleteCustomer(@PathVariable("id") Long customerId) {
        return ResponseEntity.ok(customerService.deleteCustomer(customerId));
    }


}

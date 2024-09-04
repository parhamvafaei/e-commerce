package com.ecommerce.customer.controller;

import com.ecommerce.customer.dto.CustomerRequest;
import com.ecommerce.customer.dto.CustomerResponse;
import com.ecommerce.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerResponse> createCustomer(
            @Validated @RequestBody CustomerRequest customerRequest) {

        CustomerResponse customerResponse = customerService.create(customerRequest);
        return ResponseEntity.ok(customerResponse);
    }

    @PutMapping
    public ResponseEntity<CustomerResponse> updateCustomer(
            @Validated @RequestBody CustomerRequest customerRequest) {

        CustomerResponse customerResponse = customerService.update(customerRequest);
        return ResponseEntity.ok(customerResponse);
    }

    @PatchMapping(value = "{customer-id}")
    public ResponseEntity<CustomerResponse> updateCustomer(
            @PathVariable(value = "customer-id") String customer_id, @Validated @RequestBody CustomerRequest customerRequest) {

        CustomerResponse customerResponse = customerService.updatePartially(customer_id, customerRequest);
        return ResponseEntity.ok(customerResponse);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponse>> findAll() {
        return ResponseEntity.ok(customerService.findAllCustomers());
    }

    @GetMapping("/exists/{customer-id}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable("customer-id") String customerId
    ) {
        return ResponseEntity.ok(customerService.existsById(customerId));
    }

    @GetMapping("/{customer-id}")
    public ResponseEntity<CustomerResponse> findById(
            @PathVariable("customer-id") String customerId
    ) {
        return ResponseEntity.ok(customerService.findById(customerId));
    }

    @DeleteMapping("/{customer-id}")
    public ResponseEntity<Void> delete(
            @PathVariable("customer-id") String customerId
    ) {
        customerService.deleteCustomer(customerId);
        return ResponseEntity.accepted().build();
    }
}

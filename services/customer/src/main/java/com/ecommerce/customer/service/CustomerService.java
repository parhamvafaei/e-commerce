package com.ecommerce.customer.service;

import com.ecommerce.customer.dto.CustomerRequest;
import com.ecommerce.customer.dto.CustomerResponse;
import com.ecommerce.customer.exceprion.CustomerNotFoundException;
import com.ecommerce.customer.mapper.CustomerMapper;
import com.ecommerce.customer.model.Customer;
import com.ecommerce.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CustomerService {

    private final CustomerMapper customerMapper;
    private final CustomerRepository customerRepository;

    public CustomerResponse create(CustomerRequest customerRequest) {

        Customer customer = customerRepository.save(customerMapper.toCustomer(customerRequest));
        return customerMapper.toResponse(customer);
    }

    public CustomerResponse updatePartially(String id, CustomerRequest customerRequest) {

        Customer customer = customerRepository.findById(UUID.fromString(id)).orElseThrow(() ->
                new CustomerNotFoundException(String.format("no Customer found with ID: %s", id)));
        customerMapper.mergeToCustomer(customer, customerRequest);
        return customerMapper.toResponse(customerRepository.save(customer));
    }

    public CustomerResponse update(CustomerRequest customerRequest) {

        Customer customer = customerRepository.findById(UUID.fromString(customerRequest.id())).orElseThrow(() ->
                new CustomerNotFoundException(String.format("no Customer found with ID: %s", customerRequest.id())));
        return customerMapper.toResponse(customerRepository.save(customer));
    }

    public CustomerResponse findById(String customerId) {

        return customerRepository.findById(UUID.fromString(customerId))
                .map(customerMapper::toResponse)
                .orElseThrow(() ->
                        new CustomerNotFoundException(String.format("no Customer found with ID: %s", customerId)));
    }

    public List<CustomerResponse> findAllCustomers() {

        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    public Boolean existsById(String customerId) {

        return customerRepository.findById(UUID.fromString(customerId)).isPresent();
    }

    public void deleteCustomer(String customerId) {

        customerRepository.deleteById(UUID.fromString(customerId));
    }
}

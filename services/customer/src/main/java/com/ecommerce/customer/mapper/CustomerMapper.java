package com.ecommerce.customer.mapper;

import com.ecommerce.customer.dto.CustomerRequest;
import com.ecommerce.customer.dto.CustomerResponse;
import com.ecommerce.customer.model.Customer;
import org.mapstruct.*;

@Mapper
public interface CustomerMapper {

    CustomerResponse toResponse(Customer customer);

    Customer toCustomer(CustomerRequest customerRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void mergeToCustomer(@MappingTarget Customer customer, CustomerRequest customerRequest);
}

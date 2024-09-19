package com.ecommerce.customer.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

@Builder
@Data
@Validated
public class Address {

    private String street;
    private String houseNumber;
    private String zipCode;
}
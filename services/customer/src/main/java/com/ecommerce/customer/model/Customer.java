package com.ecommerce.customer.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Builder
@Document
public class Customer {

    @Id
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
    private Address address;
}

package com.ecommerce.product.exception;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper=true)
public class ProductPurchaseException extends RuntimeException {

    public ProductPurchaseException(String message) {
        super(message);
    }
}

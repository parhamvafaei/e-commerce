package com.ecommerce.customer.exceprion.handler;

import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
) {

}

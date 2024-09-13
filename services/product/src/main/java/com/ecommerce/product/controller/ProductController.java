package com.ecommerce.product.controller;

import com.ecommerce.product.dto.ProductPurchaseRequest;
import com.ecommerce.product.dto.ProductPurchaseResponse;
import com.ecommerce.product.dto.ProductRequest;
import com.ecommerce.product.dto.ProductResponse;
import com.ecommerce.product.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService service;

    @PostMapping
    public ResponseEntity<Long> createProduct(
            @RequestBody @Valid ProductRequest request) {

        return ResponseEntity.ok(service.createProduct(request));
    }


    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> request) {

        return ResponseEntity.ok(service.purchaseProducts(request));
    }


    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(
            @PathVariable("product-id") Long productId) {

        return ResponseEntity.ok(service.findById(productId));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {

        return ResponseEntity.ok(service.findAll());
    }
}
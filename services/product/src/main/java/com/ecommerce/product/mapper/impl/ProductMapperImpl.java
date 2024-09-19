package com.ecommerce.product.mapper.impl;

import com.ecommerce.product.dto.ProductPurchaseResponse;
import com.ecommerce.product.dto.ProductRequest;
import com.ecommerce.product.dto.ProductResponse;
import com.ecommerce.product.mapper.ProductMapper;
import com.ecommerce.product.model.Category;
import com.ecommerce.product.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toProduct(ProductRequest productRequest) {

        return Product.builder()
                .id(productRequest.id().longValue())
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .category(
                        Category.builder()
                                .id(productRequest.categoryId())
                                .build())
                .build();
    }

    @Override
    public ProductResponse toProductResponse(Product product) {

        return ProductResponse.builder()
                .id(product.getId().intValue())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .categoryId(product.getCategory().getId())
                .categoryName(product.getCategory().getName())
                .categoryDescription(product.getCategory().getDescription())
                .build();
    }

    @Override
    public ProductPurchaseResponse toproductPurchaseResponse(Product product, double quantity) {

        return ProductPurchaseResponse.builder()
                .productId(product.getId().intValue())
                .quantity(quantity)
                .price(product.getPrice())
                .description(product.getDescription())
                .build();
    }
}
package com.ecommerce.product.mapper;

import com.ecommerce.product.dto.ProductPurchaseResponse;
import com.ecommerce.product.dto.ProductRequest;
import com.ecommerce.product.dto.ProductResponse;
import com.ecommerce.product.model.Product;

public interface ProductMapper {

    Product toProduct(ProductRequest productRequest);

    ProductResponse toProductResponse(Product product);

    ProductPurchaseResponse toproductPurchaseResponse(Product product, double quantity);
}

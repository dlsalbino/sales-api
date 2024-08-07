package com.azusah.infrastructure.mapper;

import com.azusah.domain.entity.Product;
import com.azusah.infrastructure.controller.payload.request.ProductRequest;
import com.azusah.infrastructure.controller.payload.response.ProductResponse;
import com.azusah.repository.entity.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public ProductEntity toProductEntityFrom(Product productDomain) {
        return ProductEntity.builder()
                .id(productDomain.getId())
                .description(productDomain.getDescription())
                .price(productDomain.getPrice())
                .build();
    }

    public Product toProductDomainFrom(ProductEntity entity) {
        return Product.builder()
                .id(entity.getId())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .build();
    }

    public Product toProductDomainFrom(ProductRequest request) {
        return Product.builder()
                .description(request.getDescription())
                .price(request.getPrice())
                .build();
    }

    public ProductResponse toProductResponseFrom(Product productDomain) {
        return ProductResponse.builder()
                .id(productDomain.getId())
                .description(productDomain.getDescription())
                .price(productDomain.getPrice())
                .build();
    }
}

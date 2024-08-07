package com.azusah.usecase.mock;

import com.azusah.domain.entity.Product;

import java.math.BigDecimal;

public class ProductMock {

    public static Product getProductDomain(Long withId) {
        return Product.builder()
                .id(withId)
                .description("Macarrão")
                .price(new BigDecimal("5.00"))
                .build();
    }
}

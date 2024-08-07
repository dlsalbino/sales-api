package com.azusah.usecase;

import com.azusah.domain.entity.Product;

public interface CreateProductUseCase {

    Product execute(Product product);
}

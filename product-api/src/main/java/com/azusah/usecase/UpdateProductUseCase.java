package com.azusah.usecase;

import com.azusah.domain.entity.Product;

public interface UpdateProductUseCase {

    Product execute(Long id, Product product);
}

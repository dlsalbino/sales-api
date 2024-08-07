package com.azusah.usecase;

import com.azusah.domain.entity.Product;

public interface RetrieveProductUseCase {

    Product execute(Long id);
}

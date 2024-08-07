package com.azusah.usecase.impl;

import com.azusah.domain.entity.Product;
import com.azusah.gateway.ProductPersistenceGateway;
import com.azusah.usecase.CreateProductUseCase;
import org.springframework.stereotype.Component;

@Component
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductPersistenceGateway persistenceGateway;

    public CreateProductUseCaseImpl(ProductPersistenceGateway persistenceGateway) {
        this.persistenceGateway = persistenceGateway;
    }

    @Override
    public Product execute(Product product) {
        return persistenceGateway.create(product);
    }
}

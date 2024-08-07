package com.azusah.usecase.impl;

import com.azusah.domain.entity.Product;
import com.azusah.gateway.ProductPersistenceGateway;
import com.azusah.usecase.UpdateProductUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdateProductUseCaseImpl implements UpdateProductUseCase {

    private final ProductPersistenceGateway persistenceGateway;

    public UpdateProductUseCaseImpl(ProductPersistenceGateway persistenceGateway) {
        this.persistenceGateway = persistenceGateway;
    }

    @Override
    public Product execute(Long id, Product product) {
        return persistenceGateway.update(id, product);
    }
}

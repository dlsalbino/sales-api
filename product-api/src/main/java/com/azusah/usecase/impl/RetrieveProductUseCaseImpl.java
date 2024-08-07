package com.azusah.usecase.impl;

import com.azusah.domain.entity.Product;
import com.azusah.gateway.ProductPersistenceGateway;
import com.azusah.usecase.RetrieveProductUseCase;
import org.springframework.stereotype.Component;

@Component
public class RetrieveProductUseCaseImpl implements RetrieveProductUseCase {

    private final ProductPersistenceGateway persistenceGateway;

    public RetrieveProductUseCaseImpl(ProductPersistenceGateway persistenceGateway) {
        this.persistenceGateway = persistenceGateway;
    }

    @Override
    public Product execute(Long id) {
        return persistenceGateway.retrieve(id);
    }
}

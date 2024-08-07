package com.azusah.usecase.impl;

import com.azusah.gateway.ProductPersistenceGateway;
import com.azusah.usecase.DeleteProductUseCase;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductPersistenceGateway persistenceGateway;

    public DeleteProductUseCaseImpl(ProductPersistenceGateway persistenceGateway) {
        this.persistenceGateway = persistenceGateway;
    }

    @Override
    public void execute(Long id) {
        persistenceGateway.delete(id);
    }
}

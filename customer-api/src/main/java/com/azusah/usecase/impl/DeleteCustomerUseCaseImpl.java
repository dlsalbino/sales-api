package com.azusah.usecase.impl;

import com.azusah.gateway.CustomerPersistenceGateway;
import com.azusah.usecase.DeleteCustomerUseCase;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerUseCaseImpl implements DeleteCustomerUseCase {

    private final CustomerPersistenceGateway persistenceGateway;

    public DeleteCustomerUseCaseImpl(CustomerPersistenceGateway persistenceGateway) {
        this.persistenceGateway = persistenceGateway;
    }

    @Override
    public void execute(Long id) {
        persistenceGateway.delete(id);
    }
}

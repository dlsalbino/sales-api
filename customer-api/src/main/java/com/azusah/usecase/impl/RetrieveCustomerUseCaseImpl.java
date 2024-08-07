package com.azusah.usecase.impl;

import com.azusah.domain.entity.Customer;
import com.azusah.gateway.CustomerPersistenceGateway;
import com.azusah.usecase.RetrieveCustomerUseCase;
import org.springframework.stereotype.Component;

@Component
public class RetrieveCustomerUseCaseImpl implements RetrieveCustomerUseCase {

    private final CustomerPersistenceGateway persistenceGateway;

    public RetrieveCustomerUseCaseImpl(CustomerPersistenceGateway persistenceGateway) {
        this.persistenceGateway = persistenceGateway;
    }

    @Override
    public Customer execute(Long id) {
        return persistenceGateway.findById(id);
    }
}

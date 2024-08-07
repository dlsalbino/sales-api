package com.azusah.usecase.impl;

import com.azusah.domain.entity.Customer;
import com.azusah.gateway.CustomerPersistenceGateway;
import com.azusah.infrastructure.mapper.CustomerMapper;
import com.azusah.usecase.UpdateCustomerUseCase;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final CustomerPersistenceGateway persistenceGateway;
    private final CustomerMapper mapper;

    public UpdateCustomerUseCaseImpl(CustomerPersistenceGateway persistenceGateway, CustomerMapper mapper) {
        this.persistenceGateway = persistenceGateway;
        this.mapper = mapper;
    }

    @Override
    public Customer execute(Long id, Customer customer) {
        return persistenceGateway.update(id, mapper.toCustomerEntityFrom(customer));
    }
}

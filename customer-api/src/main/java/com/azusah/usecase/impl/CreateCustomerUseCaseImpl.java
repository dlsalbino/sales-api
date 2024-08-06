package com.azusah.usecase.impl;

import com.azusah.domain.entity.Customer;
import com.azusah.gateway.CustomerPersistenceGateway;
import com.azusah.infrastructure.mapper.CustomerMapper;
import com.azusah.usecase.CreateCustomerUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    private final CustomerPersistenceGateway persistenceGateway;
    private final CustomerMapper mapper;

    public CreateCustomerUseCaseImpl(CustomerPersistenceGateway persistenceGateway, CustomerMapper mapper) {
        this.persistenceGateway = persistenceGateway;
        this.mapper = mapper;
    }

    @Override
    public Customer execute(Customer customer) {
        return persistenceGateway.create(mapper.toCustomerEntityFrom(customer));
    }
}

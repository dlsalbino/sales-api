package com.azusah.usecase.impl;

import com.azusah.domain.entity.Customer;
import com.azusah.gateway.CustomerPersistenceGateway;
import com.azusah.infrastructure.mapper.CustomerMapper;
import com.azusah.usecase.UpdateCustomerUseCase;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    private final CustomerPersistenceGateway customerPersistenceGateway;
    private final CustomerMapper mapper;

    public UpdateCustomerUseCaseImpl(CustomerPersistenceGateway customerPersistenceGateway, CustomerMapper mapper) {
        this.customerPersistenceGateway = customerPersistenceGateway;
        this.mapper = mapper;
    }

    @Override
    public Customer execute(Customer customer) {
        return customerPersistenceGateway.update(mapper.toCustomerEntityFrom(customer));
    }
}

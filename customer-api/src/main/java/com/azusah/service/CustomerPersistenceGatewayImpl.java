package com.azusah.service;

import com.azusah.domain.entity.Customer;
import com.azusah.gateway.CustomerPersistenceGateway;
import com.azusah.infrastructure.mapper.CustomerMapper;
import com.azusah.repository.CustomerRepository;
import com.azusah.repository.entity.CustomerEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerPersistenceGatewayImpl implements CustomerPersistenceGateway {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerPersistenceGatewayImpl(CustomerRepository repository, CustomerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Customer create(CustomerEntity customer) {
        return mapper.toCustomerDomainFrom(repository.save(customer));
    }
}

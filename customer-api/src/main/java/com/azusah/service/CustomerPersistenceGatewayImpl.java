package com.azusah.service;

import com.azusah.domain.entity.Customer;
import com.azusah.domain.exception.CustomerNotFoundException;
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

    @Override
    public Customer update(CustomerEntity customer) {
        CustomerEntity customerEntity = repository.findById(customer.getId())
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id=" + customer.getId() + " not found."));

        var updated = CustomerEntity.builder()
                .id(customerEntity.getId())
                .name(customer.getName())
                .purchaseLimitValue(customer.getPurchaseLimitValue())
                .invoiceClosingDay(customer.getInvoiceClosingDay())
                .build();

        return mapper.toCustomerDomainFrom(repository.save(updated));
    }

    @Override
    public Customer findById(Long id) {
        return repository.findById(id)
                .map(mapper::toCustomerDomainFrom)
                .orElseThrow(() -> new CustomerNotFoundException("Customer with id=" + id + " not found."));
    }
}

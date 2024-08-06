package com.azusah.gateway;

import com.azusah.domain.entity.Customer;
import com.azusah.repository.entity.CustomerEntity;

public interface CustomerPersistenceGateway {

    Customer create(CustomerEntity customer);

    Customer update(CustomerEntity customer);
}

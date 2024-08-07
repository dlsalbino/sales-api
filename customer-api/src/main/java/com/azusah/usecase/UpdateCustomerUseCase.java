package com.azusah.usecase;

import com.azusah.domain.entity.Customer;

public interface UpdateCustomerUseCase {

    Customer execute(Long id, Customer customer);
}

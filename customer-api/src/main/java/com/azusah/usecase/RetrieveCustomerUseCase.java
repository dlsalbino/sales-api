package com.azusah.usecase;

import com.azusah.domain.entity.Customer;

public interface RetrieveCustomerUseCase {

    Customer execute(Long id);
}

package com.azusah.usecase.impl;

import com.azusah.domain.entity.Customer;
import com.azusah.usecase.CreateCustomerUseCase;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerUseCaseImpl implements CreateCustomerUseCase {

    @Override
    public Customer execute(Customer customer) {
        return Customer.builder()
                .id(1L)
                .name(customer.getName())
                .purchaseLimitValue(customer.getPurchaseLimitValue())
                .invoiceClosingDay(customer.getInvoiceClosingDay())
                .build();
    }
}

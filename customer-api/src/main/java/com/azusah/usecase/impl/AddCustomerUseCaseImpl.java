package com.azusah.usecase.impl;

import com.azusah.domain.entity.Customer;
import com.azusah.usecase.AddCustomerUseCase;

public class AddCustomerUseCaseImpl implements AddCustomerUseCase {

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

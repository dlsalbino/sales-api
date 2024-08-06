package com.azusah.usecase.mock;

import com.azusah.domain.entity.Customer;
import com.azusah.repository.entity.CustomerEntity;

import java.math.BigDecimal;

public class CustomerMock {

    public static Customer getCustomerDomain(Long withId){
        return Customer.builder()
                .id(withId)
                .name("Daniel")
                .purchaseLimitValue(new BigDecimal("1000.00"))
                .invoiceClosingDay(20)
                .build();
    }

    public static CustomerEntity getCustomerEntity(Long withId){
        return CustomerEntity.builder()
                .id(withId)
                .name("Daniel")
                .purchaseLimitValue(new BigDecimal("1000.00"))
                .invoiceClosingDay(20)
                .build();
    }
}

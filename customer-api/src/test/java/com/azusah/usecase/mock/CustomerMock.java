package com.azusah.usecase.mock;

import com.azusah.domain.entity.Customer;
import com.azusah.repository.entity.CustomerEntity;

import java.math.BigDecimal;

public class CustomerMock {

    public static Customer getCustomerDomain(){
        return Customer.builder()
                .name("Daniel")
                .purchaseLimitValue(new BigDecimal("1000.00"))
                .invoiceClosingDay(20)
                .build();
    }
    public static Customer getCustomerDomainWithId() {
        return Customer.builder()
                .id(1L)
                .name("Daniel")
                .purchaseLimitValue(new BigDecimal("1000.00"))
                .invoiceClosingDay(20)
                .build();
    }

    public static CustomerEntity getCustomerEntityWithoutId(){
        return CustomerEntity.builder()
                .name("Daniel")
                .purchaseLimitValue(new BigDecimal("1000.00"))
                .invoiceClosingDay(20)
                .build();
    }


}

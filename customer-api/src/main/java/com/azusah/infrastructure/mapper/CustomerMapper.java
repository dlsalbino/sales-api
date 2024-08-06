package com.azusah.infrastructure.mapper;

import com.azusah.domain.entity.Customer;
import com.azusah.infrastructure.controller.payload.request.CustomerRequest;
import com.azusah.infrastructure.controller.payload.response.CustomerResponse;
import com.azusah.repository.entity.CustomerEntity;
import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {
    public Customer toCustomerDomainFrom(CustomerRequest customerRequest) {
        return Customer.builder()
                .name(customerRequest.getName())
                .purchaseLimitValue(customerRequest.getPurchaseLimitValue())
                .invoiceClosingDay(customerRequest.getInvoiceClosingDay())
                .build();
    }

    public CustomerResponse toCustomerResponseFrom(Customer customerDomain) {
        return CustomerResponse.builder()
                .id(customerDomain.getId())
                .name(customerDomain.getName())
                .purchaseLimitValue(customerDomain.getPurchaseLimitValue())
                .invoiceClosingDay(customerDomain.getInvoiceClosingDay())
                .build();
    }

    public CustomerEntity toCustomerEntityFrom(Customer customerDomain) {
        return CustomerEntity.builder()
                .name(customerDomain.getName())
                .purchaseLimitValue(customerDomain.getPurchaseLimitValue())
                .invoiceClosingDay(customerDomain.getInvoiceClosingDay())
                .build();
    }

    public Customer toCustomerDomainFrom(CustomerEntity customerEntity) {
        return Customer.builder()
                .id(customerEntity.getId())
                .name(customerEntity.getName())
                .purchaseLimitValue(customerEntity.getPurchaseLimitValue())
                .invoiceClosingDay(customerEntity.getInvoiceClosingDay())
                .build();
    }
}

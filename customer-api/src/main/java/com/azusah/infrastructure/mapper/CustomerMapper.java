package com.azusah.infrastructure.mapper;

import com.azusah.domain.entity.Customer;
import com.azusah.infrastructure.controller.payload.request.CustomerRequest;
import com.azusah.infrastructure.controller.payload.response.CustomerResponse;
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
}

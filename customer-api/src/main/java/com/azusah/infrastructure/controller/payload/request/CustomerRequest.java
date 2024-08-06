package com.azusah.infrastructure.controller.payload.request;

import java.math.BigDecimal;

public class CustomerRequest {
    private Long id;
    private String name;
    private BigDecimal purchaseLimitValue;
    private Integer invoiceClosingDay;

    public CustomerRequest() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPurchaseLimitValue() {
        return purchaseLimitValue;
    }

    public Integer getInvoiceClosingDay() {
        return invoiceClosingDay;
    }

    @Override
    public String toString() {
        return "CustomerRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purchaseLimitValue=" + purchaseLimitValue +
                ", invoiceClosingDay=" + invoiceClosingDay +
                '}';
    }
}

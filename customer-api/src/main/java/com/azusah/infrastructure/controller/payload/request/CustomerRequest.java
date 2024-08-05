package com.azusah.infrastructure.controller.payload.request;

import java.math.BigDecimal;

public class CustomerRequest {
    private String name;
    private BigDecimal purchaseLimitValue;
    private Integer invoiceClosingDay;

    public CustomerRequest() {
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
                "name='" + name + '\'' +
                ", purchaseLimitValue=" + purchaseLimitValue +
                ", invoiceClosingDay=" + invoiceClosingDay +
                '}';
    }
}

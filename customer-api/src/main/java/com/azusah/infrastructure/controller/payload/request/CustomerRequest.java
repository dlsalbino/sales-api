package com.azusah.infrastructure.controller.payload.request;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class CustomerRequest {

    @NotNull(message = "Field 'name' is required.")
    @NotBlank(message = "Please type a valid value on field 'name'")
    @Size(min = 3, max = 100, message
            = "The field 'name' must be between 3 and 100 characters")
    private String name;

    @NotNull(message = "Field 'purchaseLimitValue' is required.")
    @PositiveOrZero(message = "The value must be greater than or equal 0.00")
    private BigDecimal purchaseLimitValue;

    @NotNull(message = "Field 'invoiceClosingDay' is required.")
    @Min(value = 1, message = "A day must be greater than or equal 1")
    @Max(value = 31, message = "A day must be less than or equal 31")
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

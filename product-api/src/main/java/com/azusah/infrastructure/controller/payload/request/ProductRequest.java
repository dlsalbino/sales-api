package com.azusah.infrastructure.controller.payload.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class ProductRequest {

    private Long id;

    @NotNull(message = "Field 'description' is required.")
    @NotBlank(message = "Please type a valid value on field 'description'")
    @Size(min = 3, max = 100, message
            = "The field 'description' must be between 3 and 100 characters")
    private String description;

    @NotNull(message = "Field 'price' is required.")
    @PositiveOrZero(message = "The value must be greater than or equal 0.00")
    private BigDecimal price;

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }
}

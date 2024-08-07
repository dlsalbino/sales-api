package com.azusah.domain.entity;

import java.math.BigDecimal;

public class Product {

    private final Long id;
    private final String description;
    private final BigDecimal price;

    public Product(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.price = builder.price;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }

    public static class Builder {
        private Long id;
        private String description;
        private BigDecimal price;


        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}

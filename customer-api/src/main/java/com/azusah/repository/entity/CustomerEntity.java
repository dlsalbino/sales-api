package com.azusah.repository.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "purchase_limit_value")
    private BigDecimal purchaseLimitValue;

    @Column(name = "invoice_closing_day")
    private Integer invoiceClosingDay;

    public CustomerEntity() {
    }

    public CustomerEntity(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.purchaseLimitValue = builder.purchaseLimitValue;
        this.invoiceClosingDay = builder.invoiceClosingDay;
    }

    public static Builder builder() {
        return new Builder();
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
        return "CustomerEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purchaseLimitValue=" + purchaseLimitValue +
                ", invoiceClosingDay=" + invoiceClosingDay +
                '}';
    }

    public static class Builder {
        private Long id;
        private String name;
        private BigDecimal purchaseLimitValue;
        private Integer invoiceClosingDay;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder purchaseLimitValue(BigDecimal value) {
            this.purchaseLimitValue = value;
            return this;
        }

        public Builder invoiceClosingDay(Integer dayOfMonth) {
            this.invoiceClosingDay = dayOfMonth;
            return this;
        }

        public CustomerEntity build() {
            return new CustomerEntity(this);
        }
    }
}

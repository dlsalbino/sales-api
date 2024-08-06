package com.azusah.usecase;

import com.azusah.domain.entity.Customer;
import com.azusah.usecase.impl.CreateCustomerUseCaseImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class CreateCustomerUseCaseTest {

    @InjectMocks
    private CreateCustomerUseCaseImpl addCustomerUseCase;

    @Test
    @DisplayName("Given a validated customer data, should return it persisted.")
    void testAddCustomer() {

        //given
        var customer = Customer.builder()
                .name("Daniel")
                .purchaseLimitValue(new BigDecimal("1000.00"))
                .invoiceClosingDay(20)
                .build();

        //when
        Customer customerActual = addCustomerUseCase.execute(customer);

        //then
        assertThat(customerActual)
                .isNotNull()
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("name", "Daniel")
                .hasFieldOrPropertyWithValue("purchaseLimitValue", new BigDecimal("1000.00"))
                .hasFieldOrPropertyWithValue("invoiceClosingDay", 20);
    }
}

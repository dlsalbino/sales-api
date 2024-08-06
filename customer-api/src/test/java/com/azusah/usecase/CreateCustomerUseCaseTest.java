package com.azusah.usecase;

import com.azusah.domain.entity.Customer;
import com.azusah.infrastructure.mapper.CustomerMapper;
import com.azusah.repository.entity.CustomerEntity;
import com.azusah.service.CustomerPersistenceGatewayImpl;
import com.azusah.usecase.impl.CreateCustomerUseCaseImpl;
import com.azusah.usecase.mock.CustomerMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateCustomerUseCaseTest {

    @InjectMocks
    private CreateCustomerUseCaseImpl addCustomerUseCase;

    @Mock
    private CustomerPersistenceGatewayImpl persistenceGateway;

    @Mock
    private CustomerMapper mapper;

    @Test
    @DisplayName("Given a validated customer data, should return it persisted.")
    void testAddCustomer() {

        //given
        var customer = Customer.builder()
                .name("Daniel")
                .purchaseLimitValue(new BigDecimal("1000.00"))
                .invoiceClosingDay(20)
                .build();
        when(mapper.toCustomerEntityFrom(any(Customer.class))).thenReturn(CustomerMock.getCustomerEntity(null));
        when(persistenceGateway.create(any(CustomerEntity.class))).thenReturn(CustomerMock.getCustomerDomain(1L));

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

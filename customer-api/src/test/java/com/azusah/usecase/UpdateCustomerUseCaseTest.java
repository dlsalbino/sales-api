package com.azusah.usecase;

import com.azusah.domain.entity.Customer;
import com.azusah.domain.exception.CustomerNotFoundException;
import com.azusah.infrastructure.mapper.CustomerMapper;
import com.azusah.repository.entity.CustomerEntity;
import com.azusah.service.CustomerPersistenceGatewayImpl;
import com.azusah.usecase.impl.UpdateCustomerUseCaseImpl;
import com.azusah.usecase.mock.CustomerMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateCustomerUseCaseTest {

    @InjectMocks
    private UpdateCustomerUseCaseImpl updateCustomerUseCase;

    @Mock
    private CustomerMapper mapper;

    @Mock
    private CustomerPersistenceGatewayImpl customerPersistenceGateway;

    @Test
    @DisplayName("Given an existent customer, should update it.")
    public void testUpdateCustomer() {
        //given
        var customerId = 1L;
        Customer customer = CustomerMock.getCustomerDomain(customerId); //here field invoiceClosingDay=20
        when(mapper.toCustomerEntityFrom(any(Customer.class))).thenReturn(CustomerMock.getCustomerEntity(customerId));
        when(customerPersistenceGateway.update(any(Long.class), any(CustomerEntity.class)))
                .thenReturn(Customer.builder()
                        .id(1L)
                        .name("Daniel")
                        .purchaseLimitValue(new BigDecimal("1000.00"))
                        .invoiceClosingDay(10)
                        .build());

        //when
        Customer customerActual = updateCustomerUseCase.execute(customerId, customer);

        //then
        assertThat(customerActual)
                .isNotNull()
                .hasFieldOrPropertyWithValue("invoiceClosingDay", 10);
    }

    @Test
    @DisplayName("Given a non existent customer, should throw an exception.")
    public void testUpdateCustomerNotFound() {
        //given
        var customerId = 1L;
        Customer customer = CustomerMock.getCustomerDomain(customerId); //field invoiceClosingDay=20
        when(mapper.toCustomerEntityFrom(any(Customer.class))).thenReturn(CustomerMock.getCustomerEntity(customerId));
        when(customerPersistenceGateway.update(any(Long.class), any(CustomerEntity.class)))
                .thenThrow(new CustomerNotFoundException("Customer with id=1 not found."));

        //when | then
        assertThrows(CustomerNotFoundException.class,
                () -> updateCustomerUseCase.execute(customerId, customer),
                "Customer with id=1 not found.");
    }
}

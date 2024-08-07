package com.azusah.usecase;

import com.azusah.domain.entity.Customer;
import com.azusah.domain.exception.CustomerNotFoundException;
import com.azusah.service.CustomerPersistenceGatewayImpl;
import com.azusah.usecase.impl.RetrieveCustomerUseCaseImpl;
import com.azusah.usecase.mock.CustomerMock;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RetrieveCustomerUseCaseTest {

    @InjectMocks
    private RetrieveCustomerUseCaseImpl retrieveCustomerUseCase;

    @Mock
    private CustomerPersistenceGatewayImpl customerPersistenceGateway;

    @Test
    @DisplayName("Given an id of an existent customer, should return it.")
    public void testRetrieveCustomer() {
        //given
        var customerId = 1L;
        when(customerPersistenceGateway.findById(any(Long.class)))
                .thenReturn(CustomerMock.getCustomerDomain(customerId));

        //when
        Customer customerActual = retrieveCustomerUseCase.execute(customerId);

        //then
        assertThat(customerActual)
                .isNotNull();
    }

    @Test
    @DisplayName("Given an id of a non existent customer, should throw an exception.")
    public void testRetrieveNonExistentCustomer() {
        //given
        var customerId = 1L;
        when(customerPersistenceGateway.findById(any(Long.class)))
                .thenThrow(new CustomerNotFoundException("Customer with id=1 not found."));

        //when | then
        assertThrows(CustomerNotFoundException.class,
                () -> retrieveCustomerUseCase.execute(customerId),
                "Customer with id=1 not found.");
    }
}
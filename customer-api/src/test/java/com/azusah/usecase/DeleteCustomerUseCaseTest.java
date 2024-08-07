package com.azusah.usecase;

import com.azusah.domain.exception.CustomerNotFoundException;
import com.azusah.service.CustomerPersistenceGatewayImpl;
import com.azusah.usecase.impl.DeleteCustomerUseCaseImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;

@ExtendWith(MockitoExtension.class)
public class DeleteCustomerUseCaseTest {

    @InjectMocks
    private DeleteCustomerUseCaseImpl deleteCustomerUseCase;

    @Mock
    private CustomerPersistenceGatewayImpl persistenceGateway;

    @Test
    @DisplayName("Given an id of an existent customer, should delete it.")
    public void testDeleteExistentCustomer() {
        //given
        var customerId = 1L;
        Mockito.doNothing().when(persistenceGateway).delete(any(Long.class));

        //when
        deleteCustomerUseCase.execute(customerId);

        //then
        Mockito.verify(persistenceGateway, times(1)).delete(any(Long.class));
    }

    @Test
    @DisplayName("Given an id of a non existent customer, should throw an exception.")
    public void testRetrieveNonExistentCustomer() {
        //given
        var customerId = 1L;
        doThrow(new CustomerNotFoundException("Customer with id=1 not found."))
                .when(persistenceGateway).delete(any(Long.class));

        //when | then
        assertThrows(CustomerNotFoundException.class,
                () -> deleteCustomerUseCase.execute(customerId),
                "Customer with id=1 not found.");
    }
}
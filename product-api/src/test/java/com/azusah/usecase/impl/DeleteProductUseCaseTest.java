package com.azusah.usecase.impl;

import com.azusah.domain.exception.ProductNotFoundException;
import com.azusah.infrastructure.service.ProductPersistenceGatewayImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DeleteProductUseCaseTest {
    @InjectMocks
    private DeleteProductUseCaseImpl deleteProductUseCase;

    @Mock
    private ProductPersistenceGatewayImpl persistenceGateway;

    @Test
    @DisplayName("Given an id of an existent product, should delete it.")
    public void testDeleteExistentProduct() {

        //given
        var productId = 1L;
        doNothing().when(persistenceGateway).delete(any(Long.class));

        //when
        deleteProductUseCase.execute(productId);

        //then
        verify(persistenceGateway, times(1)).delete(any(Long.class));
    }

    @Test
    @DisplayName("Given an id of a non existent product, should throw an exception.")
    public void testDeleteNonExistentCustomer() {
        //given
        var customerId = 1L;
        Mockito.doThrow(ProductNotFoundException.class).when(persistenceGateway).delete(any(Long.class));


        //when | then
        assertThrows(ProductNotFoundException.class,
                () -> deleteProductUseCase.execute(customerId),
                "Product with id=1 not found.");
    }
}
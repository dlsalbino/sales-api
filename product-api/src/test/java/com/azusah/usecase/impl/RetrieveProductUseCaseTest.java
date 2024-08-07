package com.azusah.usecase.impl;

import com.azusah.domain.entity.Product;
import com.azusah.infrastructure.service.ProductPersistenceGatewayImpl;
import com.azusah.usecase.mock.ProductMock;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RetrieveProductUseCaseTest {

    @InjectMocks
    private RetrieveProductUseCaseImpl retrieveProductUseCase;

    @Mock
    private ProductPersistenceGatewayImpl persistenceGateway;

    @Test
    @DisplayName("Given an id of an existent product, should return it.")
    public void testRetrieveExistentProduct() {

        //given
        var productId = 1L;
        Product productExpected = ProductMock.getProductDomain(productId);
        when(persistenceGateway.retrieve(any(Long.class))).thenReturn(productExpected);

        //when
        Product productActual = retrieveProductUseCase.execute(productId);

        //then
        assertThat(productActual)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(productExpected);
    }
}

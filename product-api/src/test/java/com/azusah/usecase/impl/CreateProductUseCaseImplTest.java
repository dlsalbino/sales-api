package com.azusah.usecase.impl;

import com.azusah.domain.entity.Product;
import com.azusah.infrastructure.service.ProductPersistenceGatewayImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static com.azusah.usecase.mock.ProductMock.getProductDomain;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreateProductUseCaseImplTest {

    @InjectMocks
    private CreateProductUseCaseImpl createProductUseCase;

    @Mock
    private ProductPersistenceGatewayImpl persistenceGateway;

    @Test
    @DisplayName("Given a valid product, should persist it")
    void testCreateProduct() {
        //given
        Product product = getProductDomain(null);
        when(persistenceGateway.create(any(Product.class))).thenReturn(getProductDomain(1L));

        //when
        Product productActual = createProductUseCase.execute(product);

        //then
        assertThat(productActual).isNotNull()
                .hasFieldOrPropertyWithValue("id", 1L)
                .hasFieldOrPropertyWithValue("description", "Macarrão")
                .hasFieldOrPropertyWithValue("price", new BigDecimal("5.00"));
    }
}
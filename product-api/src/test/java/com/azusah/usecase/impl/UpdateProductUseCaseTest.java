package com.azusah.usecase.impl;

import com.azusah.domain.entity.Product;
import com.azusah.domain.exception.ProductNotFoundException;
import com.azusah.infrastructure.service.ProductPersistenceGatewayImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.azusah.usecase.mock.ProductMock.getProductDomain;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UpdateProductUseCaseTest {

    @InjectMocks
    private UpdateProductUseCaseImpl updateProductUseCase;

    @Mock
    private ProductPersistenceGatewayImpl persistenceGateway;

    @Test
    @DisplayName("Given an existent product, should return it updated.")
    public void testUpdateExistingProduct() {

        //given
        var productId = 1L;
        Product expectedProduct = getProductDomain(1L);
        when(persistenceGateway.update(any(Long.class), any(Product.class))).thenReturn(expectedProduct);

        //when
        Product actualProduct = updateProductUseCase.execute(productId, expectedProduct);

        //then
        assertThat(actualProduct)
                .isNotNull()
                .usingRecursiveComparison()
                .isEqualTo(expectedProduct);
    }

    @Test
    @DisplayName("Given an id of a non existent product, should throw an exception.")
    public void testRetrieveNonExistentCustomer() {
        //given
        var productId = 1L;
        Product product = getProductDomain(1L);
        when(persistenceGateway.update(any(Long.class), any(Product.class)))
                .thenThrow(new ProductNotFoundException("Product with id=1 not found."));

        //when | then
        assertThrows(ProductNotFoundException.class,
                () -> updateProductUseCase.execute(productId, product),
                "Product with id=1 not found.");
    }
}

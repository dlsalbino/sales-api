package com.azusah.gateway;

import com.azusah.domain.entity.Product;

public interface ProductPersistenceGateway {

    Product create(Product product);
    Product retrieve(Long id);
    Product update(Product product);
    void delete(Long id);
}

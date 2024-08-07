package com.azusah.infrastructure.service;

import com.azusah.domain.entity.Product;
import com.azusah.domain.exception.ProductNotFoundException;
import com.azusah.gateway.ProductPersistenceGateway;
import com.azusah.infrastructure.mapper.ProductMapper;
import com.azusah.repository.ProductRepository;
import com.azusah.repository.entity.ProductEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductPersistenceGatewayImpl implements ProductPersistenceGateway {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ProductPersistenceGatewayImpl(ProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Product create(Product product) {
        ProductEntity saved = repository.save(mapper.toProductEntityFrom(product));
        return mapper.toProductDomainFrom(saved);
    }

    @Override
    public Product retrieve(Long id) {
        return repository.findById(id)
                .map(mapper::toProductDomainFrom)
                .orElseThrow(() -> new ProductNotFoundException("Product with id=" + id + " not found."));
    }

    @Override
    public Product update(Long id, Product product) {
        Product retrieved = retrieve(id);
        var updated = ProductEntity.builder().id(retrieved.getId())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
        return mapper.toProductDomainFrom(repository.save(updated));
    }

    @Override
    public void delete(Long id) {
        Product retrieved = retrieve(id);
        repository.delete(mapper.toProductEntityFrom(retrieved));
    }
}

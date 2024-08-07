package com.azusah.infrastructure.controller;

import com.azusah.domain.entity.Product;
import com.azusah.infrastructure.controller.payload.request.ProductRequest;
import com.azusah.infrastructure.controller.payload.response.ProductResponse;
import com.azusah.infrastructure.mapper.ProductMapper;
import com.azusah.usecase.CreateProductUseCase;
import com.azusah.usecase.DeleteProductUseCase;
import com.azusah.usecase.RetrieveProductUseCase;
import com.azusah.usecase.UpdateProductUseCase;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductController {

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);
    private final CreateProductUseCase createProductUseCase;
    private final RetrieveProductUseCase retrieveProductUseCase;
    private final UpdateProductUseCase updateProductUseCase;
    private final DeleteProductUseCase deleteProductUseCase;
    private final ProductMapper mapper;

    public ProductController(CreateProductUseCase createProductUseCase, RetrieveProductUseCase retrieveProductUseCase,
                             UpdateProductUseCase updateProductUseCase, DeleteProductUseCase deleteProductUseCase,
                             ProductMapper mapper) {
        this.createProductUseCase = createProductUseCase;
        this.retrieveProductUseCase = retrieveProductUseCase;
        this.updateProductUseCase = updateProductUseCase;
        this.deleteProductUseCase = deleteProductUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid ProductRequest request) {
        log.info("START :: Creating new product flow: {}", request);
        Product product = createProductUseCase.execute(mapper.toProductDomainFrom(request));
        ProductResponse response = mapper.toProductResponseFrom(product);
        log.info("FINISH :: Creating new product flow: {}", response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> retrieve(@PathVariable Long id) {
        log.info("START :: Retrieve product with id: {}", id);
        Product product = retrieveProductUseCase.execute(id);
        ProductResponse response = mapper.toProductResponseFrom(product);
        log.info("FINISH :: Retrieve product with id: {}, customer: {}", id, response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id,
                                                  @RequestBody @Valid ProductRequest request) {
        log.info("START :: Update product flow for id: {}", id);
        Product product = updateProductUseCase.execute(id, mapper.toProductDomainFrom(request));
        ProductResponse response = mapper.toProductResponseFrom(product);
        log.info("FINISH :: Update product flow for id: {}, product: {}", id, response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("START :: Delete product with id: {}", id);
        deleteProductUseCase.execute(id);
        log.info("FINISH :: Delete product with id: {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

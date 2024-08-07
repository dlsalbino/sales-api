package com.azusah.infrastructure.controller;

import com.azusah.domain.entity.Product;
import com.azusah.infrastructure.controller.payload.request.ProductRequest;
import com.azusah.infrastructure.controller.payload.response.ProductResponse;
import com.azusah.infrastructure.mapper.ProductMapper;
import com.azusah.usecase.CreateProductUseCase;
import com.azusah.usecase.RetrieveProductUseCase;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1/products")
public class ProductController {

    private final CreateProductUseCase createProductUseCase;
    private final RetrieveProductUseCase retrieveProductUseCase;
    private final ProductMapper mapper;

    public ProductController(CreateProductUseCase createProductUseCase, RetrieveProductUseCase retrieveProductUseCase,
                             ProductMapper mapper) {
        this.createProductUseCase = createProductUseCase;
        this.retrieveProductUseCase = retrieveProductUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody @Valid ProductRequest productRequest) {
        Product product = createProductUseCase.execute(mapper.toProductDomainFrom(productRequest));
        ProductResponse response = mapper.toProductResponseFrom(product);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> retrieve(@PathVariable Long id) {
        Product product = retrieveProductUseCase.execute(id);
        ProductResponse response = mapper.toProductResponseFrom(product);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

package com.azusah.infrastructure.controller;

import com.azusah.domain.entity.Customer;
import com.azusah.infrastructure.controller.payload.request.CustomerRequest;
import com.azusah.infrastructure.controller.payload.response.CustomerResponse;
import com.azusah.infrastructure.mapper.CustomerMapper;
import com.azusah.usecase.CreateCustomerUseCase;
import com.azusah.usecase.DeleteCustomerUseCase;
import com.azusah.usecase.RetrieveCustomerUseCase;
import com.azusah.usecase.UpdateCustomerUseCase;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private final CreateCustomerUseCase createCustomerUseCase;
    private final RetrieveCustomerUseCase retrieveCustomerUseCase;
    private final UpdateCustomerUseCase updateCustomerUseCase;
    private final DeleteCustomerUseCase deleteCustomerUseCase;
    private final CustomerMapper mapper;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase, RetrieveCustomerUseCase retrieveCustomerUseCase, UpdateCustomerUseCase updateCustomerUseCase, DeleteCustomerUseCase deleteCustomerUseCase, CustomerMapper mapper) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.retrieveCustomerUseCase = retrieveCustomerUseCase;
        this.updateCustomerUseCase = updateCustomerUseCase;
        this.deleteCustomerUseCase = deleteCustomerUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody @Valid CustomerRequest request) {
        log.info("START :: Creating new customer flow: {}", request);
        Customer customer = createCustomerUseCase.execute(mapper.toCustomerDomainFrom(request));
        CustomerResponse response = mapper.toCustomerResponseFrom(customer);
        log.info("FINISH :: Creating new customer flow: {}", response);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponse> retrieve(@PathVariable Long id) {
        log.info("START :: Retrieve customer with id: {}", id);
        Customer customer = retrieveCustomerUseCase.execute(id);
        CustomerResponse customerResponse = mapper.toCustomerResponseFrom(customer);
        log.info("FINISH :: Retrieve customer with id: {}, customer: {}", id, customerResponse);
        return new ResponseEntity<>(customerResponse, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponse> update(@PathVariable Long id, @RequestBody CustomerRequest request) {
        log.info("START :: Update customer flow for id: {}", id);
        Customer customer = updateCustomerUseCase.execute(id, mapper.toCustomerDomainFrom(request));
        CustomerResponse response = mapper.toCustomerResponseFrom(customer);
        log.info("FINISH :: Update customer flow: {}", response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        log.info("START :: Delete customer with id: {}", id);
        deleteCustomerUseCase.execute(id);
        log.info("FINISH :: Delete customer with id: {}", id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

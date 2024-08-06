package com.azusah.infrastructure.controller;

import com.azusah.domain.entity.Customer;
import com.azusah.infrastructure.controller.payload.request.CustomerRequest;
import com.azusah.infrastructure.controller.payload.response.CustomerResponse;
import com.azusah.infrastructure.mapper.CustomerMapper;
import com.azusah.usecase.CreateCustomerUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    private static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    private final CreateCustomerUseCase createCustomerUseCase;
    private final CustomerMapper mapper;

    public CustomerController(CreateCustomerUseCase createCustomerUseCase, CustomerMapper mapper) {
        this.createCustomerUseCase = createCustomerUseCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> create(@RequestBody CustomerRequest customerRequest) {
        log.info("START :: Creating new customer flow: {}", customerRequest);
        Customer customer = createCustomerUseCase.execute(mapper.toCustomerDomainFrom(customerRequest));
        CustomerResponse customerResponse = mapper.toCustomerResponseFrom(customer);
        log.info("FINISH :: Creating new customer flow: {}", customerResponse);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }
}

package com.azusah.infrastructure.controller;

import com.azusah.infrastructure.controller.payload.request.CustomerRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {

    @PostMapping
    public ResponseEntity<Void> addCustomer(@RequestBody CustomerRequest customerRequest) {
        System.out.println(customerRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

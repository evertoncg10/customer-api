package com.everton.customerapi.controllers;

import com.everton.customerapi.dtos.requests.CustomerRecordRequest;
import com.everton.customerapi.dtos.responses.CustomerRecordResponse;
import com.everton.customerapi.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;

    @GetMapping("/customers")
    public ResponseEntity<List<CustomerRecordResponse>> getAllCustomers() {
        var customers = customerService.getAllCustomers();
        return ResponseEntity.status(HttpStatus.OK).body(customers);
    }

    @GetMapping("/customers/{cpf}")
    public ResponseEntity<CustomerRecordResponse> getCustomerByCpf(@PathVariable String cpf) {
        var customerByCpf = customerService.getCustomerByCpf(cpf);
        return ResponseEntity.status(HttpStatus.OK).body(customerByCpf);
    }
}

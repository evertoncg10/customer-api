package com.everton.customerapi.controllers;

import com.everton.customerapi.dtos.requests.CustomerRecordRequest;
import com.everton.customerapi.dtos.responses.CustomerRecordResponse;
import com.everton.customerapi.services.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/customers")
    public ResponseEntity<CustomerRecordResponse> saveCustomer(@RequestBody @Valid CustomerRecordRequest customerRecordRequest) {
        var customerRecordResponse = customerService.saveAndUpdateCustomer(customerRecordRequest);
        return ResponseEntity.ok(customerRecordResponse);
    }

    @PutMapping("/customers")
    public ResponseEntity<CustomerRecordResponse> updateCustomer(@RequestBody CustomerRecordRequest customerRecordRequest) {
        var customerRecordResponse = customerService.saveAndUpdateCustomer(customerRecordRequest);
        return ResponseEntity.ok(customerRecordResponse);
    }

    @DeleteMapping("/customers/{cpf}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String cpf) {
        customerService.deleteCustomer(cpf);
        return ResponseEntity.ok("Cliente excluido com sucesso");
    }

}

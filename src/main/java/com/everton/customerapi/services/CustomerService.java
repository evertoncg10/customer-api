package com.everton.customerapi.services;

import com.everton.customerapi.dtos.requests.CustomerRecordRequest;
import com.everton.customerapi.dtos.responses.CustomerRecordResponse;

import java.util.List;

public interface CustomerService {
    List<CustomerRecordResponse> getAllCustomers();
    CustomerRecordResponse getCustomerByCpf(String cpf);
    CustomerRecordResponse saveAndUpdateCustomer(CustomerRecordRequest customerRecordRequest);
    void deleteCustomer(String cpf);
}

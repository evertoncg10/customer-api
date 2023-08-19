package com.everton.customerapi.services;

import com.everton.customerapi.dtos.CustomerRecord;

import java.util.List;

public interface CustomerService {
    List<CustomerRecord> getAllCustomers();

    CustomerRecord getCustomerByCpf(String cpf);
}

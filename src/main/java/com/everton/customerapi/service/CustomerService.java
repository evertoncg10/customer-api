package com.everton.customerapi.service;

import com.everton.customerapi.dto.CustomerRecord;

import java.util.List;

public interface CustomerService {
    List<CustomerRecord> getAllCustomers();

    CustomerRecord getCustomerByCpf(String cpf);
}

package com.everton.customerapi.services.impl;

import com.everton.customerapi.dtos.CustomerRecord;
import com.everton.customerapi.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class CustomerServiceImpl implements CustomerService {

    @Override
    public List<CustomerRecord> getAllCustomers() {
        var customerRecord = new CustomerRecord(
                "Everton Cezar Gonçalves",
                "Everton Gonçalves",
                "12/08/1985",
                "04048238906",
                new ArrayList<>(),
                new ArrayList<>(),
                "evertoncg10@outlook.com"
        );
        return List.of(customerRecord);
    }

    @Override
    public CustomerRecord getCustomerByCpf(String cpf) {
        return new CustomerRecord(
                "Everton Cezar Gonçalves",
                "Everton Gonçalves",
                "12/08/1985",
                "04048238906",
                new ArrayList<>(),
                new ArrayList<>(),
                "evertoncg10@outlook.com"
        );
    }
}

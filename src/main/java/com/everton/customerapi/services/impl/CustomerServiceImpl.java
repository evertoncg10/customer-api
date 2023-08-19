package com.everton.customerapi.services.impl;

import com.everton.customerapi.dtos.requests.CustomerRecordRequest;
import com.everton.customerapi.dtos.responses.CustomerRecordResponse;
import com.everton.customerapi.models.CustomerModel;
import com.everton.customerapi.repositories.CustomerRepository;
import com.everton.customerapi.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public List<CustomerRecordResponse> getAllCustomers() {

        List<CustomerModel> customers = customerRepository.findAll();
        //TODO: Fazer Mapper de List<CustomerModel> para List<CustomerRecordResponse>

        var customerRecord = new CustomerRecordResponse(
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
    public CustomerRecordResponse getCustomerByCpf(String cpf) {
        Optional<CustomerModel> customer = customerRepository.findById(cpf);

        //TODO: Fazer Mapper de CustomerModel para CustomerRecordResponse
        return new CustomerRecordResponse(
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

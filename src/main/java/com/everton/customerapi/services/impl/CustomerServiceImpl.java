package com.everton.customerapi.services.impl;

import com.everton.customerapi.dtos.responses.CustomerRecordResponse;
import com.everton.customerapi.mappers.CustomerResponseMapper;
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

    private CustomerResponseMapper customerResponseMapper;

    @Override
    public List<CustomerRecordResponse> getAllCustomers() {
        List<CustomerModel> customers = customerRepository.findAll();
        return customerResponseMapper.sourceToDestination(customers);
    }

    @Override
    public CustomerRecordResponse getCustomerByCpf(String cpf) {
        CustomerRecordResponse response = new CustomerRecordResponse("", "", "", "", new ArrayList<>(), new ArrayList<>(), "");
        Optional<CustomerModel> customer = customerRepository.findById(cpf);
        if(customer.isPresent()){
            response = customerResponseMapper.sourceToDestination(customer.get());
        }
        return response;
    }
}

package com.everton.customerapi.services.impl;

import com.everton.customerapi.dtos.requests.CustomerRecordRequest;
import com.everton.customerapi.dtos.responses.CustomerRecordResponse;
import com.everton.customerapi.exceptions.NotFoundException;
import com.everton.customerapi.mappers.CustomerRequestMapper;
import com.everton.customerapi.mappers.CustomerResponseMapper;
import com.everton.customerapi.models.CustomerModel;
import com.everton.customerapi.repositories.CustomerRepository;
import com.everton.customerapi.services.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    private final CustomerRepository customerRepository;

    private final CustomerResponseMapper customerResponseMapper;

    private final CustomerRequestMapper customerRequestMapper;

    @Autowired
    public CustomerServiceImpl(
            CustomerRepository customerRepository,
            CustomerResponseMapper customerResponseMapper,
            CustomerRequestMapper customerRequestMapper
    ) {
        this.customerRepository = customerRepository;
        this.customerResponseMapper = customerResponseMapper;
        this.customerRequestMapper = customerRequestMapper;
    }

    @Override
    public List<CustomerRecordResponse> getAllCustomers() {
        List<CustomerModel> customers = customerRepository.findAll();
        var customerRecordResponses = customerResponseMapper.sourceToDestination(customers);
        logger.info("Lista de clientes: " + customerRecordResponses.toString());
        return customerRecordResponses;
    }

    @Override
    public CustomerRecordResponse getCustomerByCpf(String cpf) {
        var customerOptional = customerRepository.findById(cpf);
        var customer = customerOptional.orElseThrow(() -> new NotFoundException("Cliente não encontrado na base de dados."));
        return customerResponseMapper.sourceToDestination(customer);
    }

    @Override
    public CustomerRecordResponse saveAndUpdateCustomer(CustomerRecordRequest customerRecordRequest) {
        var customerModel = customerRequestMapper.destinationToSource(customerRecordRequest);
        var customerSaved = customerRepository.save(customerModel);
        return customerResponseMapper.sourceToDestination(customerSaved);
    }

    @Override
    public void deleteCustomer(String cpf) {
        var customerDeletar = customerRepository.findById(cpf);
        var customer = customerDeletar.orElseThrow(() -> new NotFoundException("Cliente não encontrado na base de dados."));
        customerRepository.delete(customer);
    }
}

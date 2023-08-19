package com.everton.customerapi.mappers;

import com.everton.customerapi.dtos.requests.CustomerRecordRequest;
import com.everton.customerapi.models.CustomerModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CustomerRequestMapper extends CustomMapper<CustomerModel, CustomerRecordRequest> {

    @Override
    CustomerRecordRequest sourceToDestination(CustomerModel source);

    @Override
    List<CustomerRecordRequest> sourceToDestination(List<CustomerModel> sourceList);

    @Override
    CustomerModel destinationToSource(CustomerRecordRequest source);

    @Override
    List<CustomerModel> destinationToSource(List<CustomerRecordRequest> destinationList);

}

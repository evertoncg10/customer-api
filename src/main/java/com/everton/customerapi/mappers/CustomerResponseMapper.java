package com.everton.customerapi.mappers;

import com.everton.customerapi.dtos.responses.CustomerRecordResponse;
import com.everton.customerapi.models.CustomerModel;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface CustomerResponseMapper extends CustomMapper<CustomerModel, CustomerRecordResponse> {

    @Override
    CustomerRecordResponse sourceToDestination(CustomerModel source);

    @Override
    List<CustomerRecordResponse> sourceToDestination(List<CustomerModel> sourceList);

    @Override
    CustomerModel destinationToSource(CustomerRecordResponse source);

    @Override
    List<CustomerModel> destinationToSource(List<CustomerRecordResponse> destinationList);

}

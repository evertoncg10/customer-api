package com.everton.customerapi.dtos.requests;

import com.everton.customerapi.dtos.AddressRecord;
import com.everton.customerapi.dtos.PhoneRecord;

import java.util.List;

public record CustomerRecordRequest(
        String cpf,
        String fullName,
        String socialName,
        String birthDate,
        List<AddressRecord> adresses,
        List<PhoneRecord> phones,
        String email
) {
}

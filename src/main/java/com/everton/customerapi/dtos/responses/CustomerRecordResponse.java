package com.everton.customerapi.dtos.responses;

import com.everton.customerapi.dtos.AddressRecord;
import com.everton.customerapi.dtos.PhoneRecord;

import java.util.List;

public record CustomerRecordResponse(
        String fullName,
        String socialName,
        String birthDate,
        String cpf,
        List<AddressRecord> adresses,
        List<PhoneRecord> phones,
        String email
) {
}

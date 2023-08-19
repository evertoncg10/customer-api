package com.everton.customerapi.dto;

import java.util.List;

public record CustomerRecordRequest(
        String fullName,
        String socialName,
        String birthDate,
        String cpf,
        List<AddressRecord> adresses,
        List<PhoneRecord> phones,
        String email
) {
}

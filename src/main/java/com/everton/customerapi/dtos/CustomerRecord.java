package com.everton.customerapi.dtos;

import java.util.List;

public record CustomerRecord(
        String fullName,
        String socialName,
        String birthDate,
        String cpf,
        List<AddressRecord> adresses,
        List<PhoneRecord> phones,
        String email
) {
}

package com.everton.customerapi.dtos.requests;

import com.everton.customerapi.dtos.AddressRecord;
import com.everton.customerapi.dtos.PhoneRecord;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record CustomerRecordRequest(
        String cpf,
        @JsonProperty("full_name")
        String fullName,
        @JsonProperty("social_name")
        String socialName,
        @JsonProperty("birth_date")
        String birthDate,
        List<AddressRecord> adresses,
        List<PhoneRecord> phones,
        String email
) {
}

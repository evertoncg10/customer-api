package com.everton.customerapi.dtos.requests;

import com.everton.customerapi.dtos.AddressRecord;
import com.everton.customerapi.dtos.PhoneRecord;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

public record CustomerRecordRequest(

        @CPF(message = "Valor do campo cpf está inválido.")
        @NotBlank(message = "Campo cpf com valor nulo ou vazio.")
        String cpf,
        @JsonProperty("full_name")
        String fullName,
        @JsonProperty("social_name")
        String socialName,
        @JsonProperty("birth_date")
        String birthDate,
        @Valid
        List<AddressRecord> adresses,
        @Valid
        List<PhoneRecord> phones,
        @Email(message = "Valor do campo email está inválido.")
        @NotBlank(message = "Campo email com valor nulo ou vazio.")
        String email
) {
}

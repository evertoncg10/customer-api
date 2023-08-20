package com.everton.customerapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record PhoneRecord(
        UUID idPhone,
        @Min(value = 1, message = "Valor do campo phones.type inválido. Valores aceitos: 1(Fixo) - 2(Celular) - 3(Comercial)")
        @Max(value = 3, message = "Valor do campo phones.type inválido. Valores aceitos: 1(Fixo) - 2(Celular) - 3(Comercial)")
        int type,
        @NotBlank(message = "Campo phones.number com valor nulo ou vazio.")
        @Size(min = 8, max = 9)
        String number,
        @NotBlank(message = "Campo phones.ddd com valor nulo ou vazio.")
        @Size(min = 2, max = 2)
        String ddd,
        @NotBlank(message = "Campo phones.ddi com valor nulo ou vazio.")
        @Size(min = 1, max = 3)
        String ddi,
        @JsonProperty("branch_line")
        String branchLine
) {
}

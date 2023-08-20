package com.everton.customerapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record AddressRecord(
        UUID idAddress,
        @Min(value = 1, message = "Valor do campo adresses.type inválido. Valores aceitos: 1(Residencial) - 2(Comercial)")
        @Max(value = 2, message = "Valor do campo adresses.type inválido. Valores aceitos: 1(Residencial) - 2(Comercial)")
        int type,
        @JsonProperty("zip_code")
        @NotBlank(message = "Campo adresses.zipCode com valor nulo ou vazio.")
        String zipCode,
        @JsonProperty("street_our_avenue")
        @NotBlank(message = "Campo adresses.streetOurAvenue com valor nulo ou vazio.")
        @Size(min = 3, max = 255)
        String streetOurAvenue,
        int number,
        String complement,
        @NotBlank(message = "Campo adresses.district com valor nulo ou vazio.")
        @Size(min = 3, max = 150)
        String district,
        @NotBlank(message = "Campo adresses.city com valor nulo ou vazio.")
        @Size(min = 3, max = 150)
        String city,
        @NotBlank(message = "Campo adresses.stade com valor nulo ou vazio.")
        @Size(min = 2, max = 2)
        String stade,
        @NotBlank(message = "Campo adresses.country com valor nulo ou vazio.")
        @Size(min = 2, max = 2)
        String country
) {
}

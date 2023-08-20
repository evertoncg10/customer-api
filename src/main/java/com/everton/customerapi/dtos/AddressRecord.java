package com.everton.customerapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record AddressRecord(
        UUID idAddress,
        int type,
        @JsonProperty("zip_code")
        String zipCode,
        @JsonProperty("street_our_avenue")
        String streetOurAvenue,
        int number,
        String complement,
        String district,
        String city,
        String stade,
        String country
) {
}

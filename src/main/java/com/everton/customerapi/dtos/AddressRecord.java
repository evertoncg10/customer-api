package com.everton.customerapi.dtos;

public record AddressRecord(
        int type,
        String zipCode,
        String streetOurAvenue,
        int number,
        String complement,
        String district,
        String city,
        String stade,
        String country
) {
}

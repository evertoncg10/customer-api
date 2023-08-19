package com.everton.customerapi.dtos;

public record PhoneRecord(
        String type,
        String number,
        String ddd,
        String ddi,
        String branch_line
) {
}

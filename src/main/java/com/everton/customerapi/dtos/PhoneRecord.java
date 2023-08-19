package com.everton.customerapi.dtos;

public record PhoneRecord(
        int type,
        String number,
        String ddd,
        String ddi,
        String branch_line
) {
}

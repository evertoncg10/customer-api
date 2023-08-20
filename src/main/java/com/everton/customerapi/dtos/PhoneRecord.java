package com.everton.customerapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public record PhoneRecord(
        UUID idPhone,
        int type,
        String number,
        String ddd,
        String ddi,
        @JsonProperty("branch_line")
        String branchLine
) {
}

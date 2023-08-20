package com.everton.customerapi.exceptions.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record Errors(
        String message,
        String field,
        Object parameter
) {}

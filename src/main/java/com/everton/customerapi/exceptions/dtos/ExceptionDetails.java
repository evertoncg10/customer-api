package com.everton.customerapi.exceptions.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ExceptionDetails(
        String title,
        int status,
        List<Errors>errors,
        String developerMessage,
        LocalDateTime timestap
) {}

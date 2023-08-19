package com.everton.customerapi.exceptions.handler;

import com.everton.customerapi.exceptions.ExceptionDetails;
import com.everton.customerapi.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleNotFoundException(NotFoundException exception) {
        ExceptionDetails exceptionDetails = ExceptionDetails.builder()
                .title("Not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .details(exception.getMessage())
                .developerMessage(exception.getClass().getName())
                .timestap(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }
}

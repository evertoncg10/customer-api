package com.everton.customerapi.exceptions.handler;

import com.everton.customerapi.exceptions.dtos.Errors;
import com.everton.customerapi.exceptions.dtos.ExceptionDetails;
import com.everton.customerapi.exceptions.NotFoundException;
import com.mysql.cj.util.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleNotFoundException(NotFoundException exception) {
        var exceptionDetails = ExceptionDetails.builder()
                .title("Not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .developerMessage(exception.getClass().getName())
                .timestap(LocalDateTime.now())
                .errors(List.of(Errors.builder().message(exception.getMessage()).build()))
                .build();
        return new ResponseEntity<>(exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<Errors> errors = getErrors(exception);
        var exceptionDetails = ExceptionDetails.builder()
                .title(HttpStatus.valueOf(status.value()).name())
                .status(status.value())
                .developerMessage(exception.getClass().getName())
                .timestap(LocalDateTime.now())
                .errors(errors)
                .build();

        return new ResponseEntity<>(exceptionDetails, status);
    }

    private List<Errors> getErrors(MethodArgumentNotValidException exception) {
        return exception.getBindingResult().getFieldErrors().stream()
                .map(error -> new Errors(error.getDefaultMessage(), error.getField(),
                        StringUtils.isNullOrEmpty(Objects.isNull(error.getRejectedValue()) ? "" : error.getRejectedValue().toString()) ? null : error.getRejectedValue()))
                .collect(Collectors.toList());
    }
}

package com.supportflow.helpdesk.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleResourceNotFoundException(ResourceNotFoundException exception, HttpServletRequest request) {
        return new ErrorResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), exception.getMessage(), request.getRequestURI());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValidationErrors(
        MethodArgumentNotValidException exception,
        HttpServletRequest request) 
    {

    List<String> errors = exception.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(field -> field.getDefaultMessage())
            .toList();

        return new ErrorResponse(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Validation error",
            request.getRequestURI(),
            errors
        );
    }
}

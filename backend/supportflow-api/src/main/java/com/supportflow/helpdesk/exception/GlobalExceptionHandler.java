package com.supportflow.helpdesk.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

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
    
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Map<String, Object>> handleBusinessException(
        BusinessException ex, HttpServletRequest request
    ) {
        Map<String, Object> body = new HashMap<>();
        
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Business rule violation");
        body.put("message", ex.getMessage());
        body.put("path", request.getRequestURI());

        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(InvalidTicketStatusException.class)
    public ResponseEntity<Map<String, Object>> handleInvalidTicketStatusException(
        InvalidTicketStatusException ex, HttpServletRequest request
    ) {
        Map<String, Object> body = new HashMap<>();
        
        body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.value());
        body.put("error", "Invalid ticket status");
        body.put("message", ex.getMessage());
        body.put("path", request.getRequestURI());

        return ResponseEntity.badRequest().body(body);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Map<String, Object>> handleAccessDeniedException(
                AccessDeniedException ex,
                HttpServletRequest request
        ) {
            Map<String, Object> body = new HashMap<>();

            body.put("timestamp", LocalDateTime.now());
            body.put("status", HttpStatus.FORBIDDEN.value());
            body.put("error", "Access denied");
            body.put("message", ex.getMessage());
            body.put("path", request.getRequestURI());

            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(body);
        }


}

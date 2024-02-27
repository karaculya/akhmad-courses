package com.example.app.controller.advice;

import com.example.app.exception.NotFoundException;
import com.example.app.model.dto.ErorrDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErorrDto> handleNotFound(Exception e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(new ErorrDto(String.valueOf(HttpStatus.NOT_FOUND.value()), e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErorrDto> handleNotValid(MethodArgumentNotValidException ex) {
        Map<String, String> allErrors = ex.getAllErrors().stream()
//                .map(e -> e.getDefaultMessage())
                .collect(Collectors.toMap(ObjectError::getObjectName, e -> e.getDefaultMessage()));
        String msg = allErrors.isEmpty() ? "поля не должны быть пустыми" : allErrors.toString();
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ErorrDto(String.valueOf(HttpStatus.BAD_REQUEST.value()), msg));
    }
}

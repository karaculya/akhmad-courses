package com.example.app.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDto {
    private String code;
    private String message;
    private Map<String, String> extended;

    public ErrorDto(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

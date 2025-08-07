package com.example.spring.exception;

public record ErrorDto(String code, String message, String path) {

    public static ErrorDto create(String code, String  message, String path) {
        return new ErrorDto(code, message, path);
    }
}


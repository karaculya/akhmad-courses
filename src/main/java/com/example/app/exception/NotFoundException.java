package com.example.app.exception;

public class NotFoundException extends RuntimeException {
    protected static final String message = "Not found";
    protected String httpStatus;

    public NotFoundException() {
        super(message);
    }

    public NotFoundException(String message) {
        super(message);
    }
}

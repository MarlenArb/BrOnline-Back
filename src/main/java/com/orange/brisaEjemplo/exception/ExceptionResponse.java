package com.orange.brisaEjemplo.exception;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ExceptionResponse {

    private String exception;
    
    private String message;
    
    private String path;
    
    public ExceptionResponse(Exception exception, String path) {
        this.exception = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.path = path;
    }

    public ExceptionResponse(Exception exception, String message, String path) {
        this.exception = exception.getClass().getSimpleName();
        this.message = message;
        this.path = path;
    }
    
    public ExceptionResponse(HttpStatus noContent, String message, String path) {
        this.exception = noContent.getClass().getSimpleName();
        this.message = message;
        this.path = path;
    }
}

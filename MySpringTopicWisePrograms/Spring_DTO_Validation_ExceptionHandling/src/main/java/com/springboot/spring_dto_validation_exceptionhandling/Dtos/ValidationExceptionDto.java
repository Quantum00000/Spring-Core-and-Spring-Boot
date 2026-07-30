package com.springboot.spring_dto_validation_exceptionhandling.Dtos;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionDto {

    private LocalDateTime dateTime;
    private Integer statusCode;
    private String error;
    private String message;
    private String path;
    private Map<String,String> fieldErrors;

    public ValidationExceptionDto(LocalDateTime dateTime, Integer statusCode, String error, String message, String path, Map<String, String> fieldErrors) {
        this.dateTime = dateTime;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
        this.fieldErrors = fieldErrors;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}

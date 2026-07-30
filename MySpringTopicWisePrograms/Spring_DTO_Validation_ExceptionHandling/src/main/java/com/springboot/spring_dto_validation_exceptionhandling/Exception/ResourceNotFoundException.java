package com.springboot.spring_dto_validation_exceptionhandling.Exception;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String message){
        super(message);
    }
}

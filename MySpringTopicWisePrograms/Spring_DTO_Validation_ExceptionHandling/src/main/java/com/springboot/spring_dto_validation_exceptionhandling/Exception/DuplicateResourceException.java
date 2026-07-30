package com.springboot.spring_dto_validation_exceptionhandling.Exception;

public class DuplicateResourceException extends RuntimeException{

    public DuplicateResourceException(String message){
        super(message);
    }
}

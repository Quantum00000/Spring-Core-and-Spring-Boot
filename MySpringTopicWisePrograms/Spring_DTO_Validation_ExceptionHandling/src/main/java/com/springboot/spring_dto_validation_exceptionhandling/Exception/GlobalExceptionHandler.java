package com.springboot.spring_dto_validation_exceptionhandling.Exception;

import com.springboot.spring_dto_validation_exceptionhandling.Dtos.ExceptionResponseDto;
import com.springboot.spring_dto_validation_exceptionhandling.Dtos.ValidationExceptionDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ExceptionResponseDto> DuplicateResourceExceptionHandler
            (DuplicateResourceException ex, HttpServletRequest request){

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );
         return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionResponseDto);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> ResourceNotFoundExceptionHandler
            (ResourceNotFoundException ex,HttpServletRequest request){

        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto(
                LocalDateTime.now(),
                HttpStatus.CONFLICT.value(),
                HttpStatus.CONFLICT.getReasonPhrase(),
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDto);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDto> MethodArgumentNotValidException
            (MethodArgumentNotValidException ex,HttpServletRequest request){

        Map<String,String> fieldError = new HashMap<>();

        ex.getBindingResult().getFieldErrors().
                forEach(error-> fieldError.put(error.getField(),error.getDefaultMessage()));

        ValidationExceptionDto validationExceptionDto = new ValidationExceptionDto(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "Validation Exception a gya re baba",
                request.getRequestURI(),
                fieldError
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(validationExceptionDto);
    }
}

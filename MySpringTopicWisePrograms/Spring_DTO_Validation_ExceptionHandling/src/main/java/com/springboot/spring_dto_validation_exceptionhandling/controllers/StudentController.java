package com.springboot.spring_dto_validation_exceptionhandling.controllers;

import com.springboot.spring_dto_validation_exceptionhandling.Dtos.CreateStudentReqDto;
import com.springboot.spring_dto_validation_exceptionhandling.Dtos.CreateStudentResDto;
import com.springboot.spring_dto_validation_exceptionhandling.Services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResDto> createStudent(@Valid @RequestBody CreateStudentReqDto createStudentReqDto){

        CreateStudentResDto createStudent = studentService.createStudent(createStudentReqDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createStudent);
    }
}

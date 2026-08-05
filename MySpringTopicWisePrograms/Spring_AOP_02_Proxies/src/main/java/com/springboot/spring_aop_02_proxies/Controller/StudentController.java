package com.springboot.spring_aop_02_proxies.Controller;

import com.springboot.spring_aop_02_proxies.Dto.StudentRequestDto;
import com.springboot.spring_aop_02_proxies.Dto.StudentResponseDto;
import com.springboot.spring_aop_02_proxies.Entities.Student;
import com.springboot.spring_aop_02_proxies.Services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> createStudent(@RequestBody @Valid StudentRequestDto requestDto){

        Student s = DtoToStudent(requestDto);

        Student student= studentService.createStudent(s);

        StudentResponseDto responseDto = StudentToDto(student);

        return ResponseEntity.status(200).body(responseDto);


    }

    private StudentResponseDto StudentToDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();

        studentResponseDto.setId(student.getId());
        studentResponseDto.setName(student.getName());
        studentResponseDto.setAge(student.getAge());
        studentResponseDto.setEmail(student.getEmail());
        studentResponseDto.setLocalDateTime(LocalDateTime.now());

        return studentResponseDto;

    }

    private Student DtoToStudent(StudentRequestDto requestDto){

        Student student = new Student();

        student.setName(requestDto.getName());
        student.setAge(requestDto.getAge());
        student.setEmail(requestDto.getEmail());

        return  student;
    }
}

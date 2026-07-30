package com.springboot.spring_dto_validation_exceptionhandling.Services;

import com.springboot.spring_dto_validation_exceptionhandling.Dtos.CreateStudentReqDto;
import com.springboot.spring_dto_validation_exceptionhandling.Dtos.CreateStudentResDto;
import com.springboot.spring_dto_validation_exceptionhandling.Entities.Student;
import com.springboot.spring_dto_validation_exceptionhandling.Exception.DuplicateResourceException;
import com.springboot.spring_dto_validation_exceptionhandling.Repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public CreateStudentResDto createStudent(CreateStudentReqDto createStudentReqDto){
        Student exsistingStudent = DtoToEntity(createStudentReqDto);

        if(emailExists(exsistingStudent)){
            throw new DuplicateResourceException("Student Already exsists");
        }

        Student student = new Student();

        student.setId(exsistingStudent.getId());
        student.setName(exsistingStudent.getName());
        student.setAge(exsistingStudent.getAge());
        student.setEmail(exsistingStudent.getEmail());

        studentRepository.save(student);

        return  EntityToDto(student);

    }

    private Student DtoToEntity(CreateStudentReqDto createStudentReqDto){
        Student student = new Student();

        student.setName(createStudentReqDto.getName());
        //student.setId(createStudentReqDto.getId());
        student.setAge(createStudentReqDto.getAge());
        student.setEmail(createStudentReqDto.getEmail());

        return student;

    }

    private CreateStudentResDto EntityToDto(Student student){

        CreateStudentResDto createStudentResDto = new CreateStudentResDto();

        createStudentResDto.setName(student.getName());
        createStudentResDto.setId(student.getId());
        createStudentResDto.setUpdatedAt(LocalDateTime.now());
        createStudentResDto.setCreateAt(LocalDateTime.now());

        return createStudentResDto;
    }

    private Boolean emailExists(Student student){
        return studentRepository.existsByEmail(student.getEmail());
    }
}

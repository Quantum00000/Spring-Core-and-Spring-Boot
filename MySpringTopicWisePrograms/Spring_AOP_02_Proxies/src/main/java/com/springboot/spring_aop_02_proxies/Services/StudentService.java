package com.springboot.spring_aop_02_proxies.Services;

import com.springboot.spring_aop_02_proxies.Entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StudentService {

    public Student createStudent(Student student){
        System.out.println("Service layer excecuted");
        //studentRepository.save(student);
        //return student;
        throw new RuntimeException("Service method se Exception Throw ho rha hai");
    }

}

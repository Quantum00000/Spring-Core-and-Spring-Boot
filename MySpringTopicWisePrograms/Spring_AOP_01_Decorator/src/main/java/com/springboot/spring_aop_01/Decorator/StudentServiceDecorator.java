package com.springboot.spring_aop_01.Decorator;

import com.springboot.spring_aop_01.Services.StudentService;
import com.springboot.spring_aop_01.Services.StudentServiceImp;
import org.springframework.stereotype.Component;

@Component
public class StudentServiceDecorator implements StudentService {
    private final StudentServiceImp studentServiceImp;

    public StudentServiceDecorator(StudentServiceImp studentServiceImp) {
        this.studentServiceImp = studentServiceImp;
    }

    @Override
    public void createstudent() {

        studentServiceImp.createstudent();
    }
}

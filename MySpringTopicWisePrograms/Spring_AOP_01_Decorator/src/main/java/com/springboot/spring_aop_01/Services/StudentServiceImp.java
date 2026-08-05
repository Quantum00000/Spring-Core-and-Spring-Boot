package com.springboot.spring_aop_01.Services;

import org.springframework.stereotype.Component;

@Component
public class StudentServiceImp implements StudentService{
    @Override
    public void createstudent() {
        System.out.println("StudentServiceImp implemented");
    }
}

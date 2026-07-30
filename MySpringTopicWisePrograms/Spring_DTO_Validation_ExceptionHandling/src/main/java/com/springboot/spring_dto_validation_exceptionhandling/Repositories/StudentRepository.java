package com.springboot.spring_dto_validation_exceptionhandling.Repositories;

import com.springboot.spring_dto_validation_exceptionhandling.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentRepository extends JpaRepository<Student,Long> {

    Boolean existsByEmail(String email);

}

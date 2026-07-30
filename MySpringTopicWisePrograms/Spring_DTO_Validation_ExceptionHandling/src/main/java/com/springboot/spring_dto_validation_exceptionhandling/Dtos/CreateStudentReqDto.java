package com.springboot.spring_dto_validation_exceptionhandling.Dtos;
import jakarta.validation.constraints.*;

public class CreateStudentReqDto {
    @NotBlank(message = "Student name should not be Empty")
    @Size(min = 2,max = 50,message = "Student name should be between 2 to 50 words")
    private String name;

    @NotNull
    @Min(5)
    private Integer age;

    @NotBlank(message = "Email should not be blank")
    @Email
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



}

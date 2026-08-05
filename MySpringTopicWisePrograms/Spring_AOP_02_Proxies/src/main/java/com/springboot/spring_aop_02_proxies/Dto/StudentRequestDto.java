package com.springboot.spring_aop_02_proxies.Dto;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Component;

@Component
public class StudentRequestDto {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY )
//    private Long id;

    @NotBlank(message = "Name should not be Null")
    private String name;
    @NotNull
    private Integer age;
    @NotBlank
    private String email;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

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

package com.springboot.spring_dto_validation_exceptionhandling;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDtoValidationExceptionHandlingApplication {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        dotenv.entries().forEach((entry)->System.setProperty(
                entry.getKey(),entry.getValue()));

        SpringApplication.run(SpringDtoValidationExceptionHandlingApplication.class, args);
    }

}

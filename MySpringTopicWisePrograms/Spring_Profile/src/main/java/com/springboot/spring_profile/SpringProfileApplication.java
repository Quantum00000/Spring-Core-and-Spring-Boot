package com.springboot.spring_profile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringProfileApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringProfileApplication.class, args);
    }

}

package com.springboot.spring_aop_01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude= DataSourceAutoConfiguration.class)
public class SpringAop01Application {

    public static void main(String[] args)  {
        SpringApplication.run(SpringAop01Application.class, args);
    }

}

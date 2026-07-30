package com.springboot.spring_filters;

import jdk.jfr.DataAmount;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringFiltersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringFiltersApplication.class, args);
    }

}

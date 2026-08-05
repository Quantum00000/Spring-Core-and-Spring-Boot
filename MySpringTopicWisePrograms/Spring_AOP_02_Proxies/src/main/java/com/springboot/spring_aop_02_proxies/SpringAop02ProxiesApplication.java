package com.springboot.spring_aop_02_proxies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringAop02ProxiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAop02ProxiesApplication.class, args);
    }

}

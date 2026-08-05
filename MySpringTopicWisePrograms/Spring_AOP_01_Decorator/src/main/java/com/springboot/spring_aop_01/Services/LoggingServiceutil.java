package com.springboot.spring_aop_01.Services;

import org.springframework.stereotype.Component;

@Component
public class LoggingServiceutil  {

    public void logStart(String className,String methodName){
        System.out.println("Starting Executing->"+className+":"+methodName);
    }

    public void logEnd(String className,String methodName){
        System.out.println("Ending Executing->"+className+":"+methodName);
    }
}

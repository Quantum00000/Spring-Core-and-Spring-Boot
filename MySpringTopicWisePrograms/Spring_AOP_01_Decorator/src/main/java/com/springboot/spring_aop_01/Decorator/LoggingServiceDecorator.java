package com.springboot.spring_aop_01.Decorator;

import com.springboot.spring_aop_01.Services.LoggingServiceutil;
import com.springboot.spring_aop_01.Services.StudentService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LoggingServiceDecorator implements StudentService {

    private final LoggingServiceutil loggingServiceutil;
    private final StudentServiceDecorator studentServiceDecorator;

    public LoggingServiceDecorator(LoggingServiceutil loggingServiceutil,StudentServiceDecorator studentServiceDecorator) {
        this.loggingServiceutil = loggingServiceutil;
        this.studentServiceDecorator=studentServiceDecorator;
    }


    @Override
    public void createstudent() {
        loggingServiceutil.logStart("LoggingServiceutil","createstudent");
        studentServiceDecorator.createstudent();
        loggingServiceutil.logEnd("LoggingServiceutil","createstudent");
    }
}

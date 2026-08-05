package com.springboot.spring_aop_02_proxies.Aspects;

import com.springboot.spring_aop_02_proxies.Entities.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class StudentLoggingAspect {



    //Before Proxy--------------------------------------------------------------------------------
    //        // Before Proxy- It can control service method execution

//    @Before("execution(com.springboot.spring_aop_02_proxies.Entities.Student " +
//            "com.springboot.spring_aop_02_proxies.Services..createStudent(..))")
//    public void logBeforeMethod(JoinPoint jointPoint){
//        System.out.println("Before proxy worked");
//
//        boolean key = false;
//        if(!key){
//            throw new RuntimeException("Exception thrown");
//        }
//    }



//    //After Proxy--------------------------------------------------------------------------------
//    //        // After Proxy- It can log after completion of service method
//
//    @After("execution(com.springboot.spring_aop_02_proxies.Entities.Student " +
//            "com.springboot.spring_aop_02_proxies.Services..createStudent(..))")
//    public void logBeforeMethod(JoinPoint jointPoint){
//        System.out.println("After proxy worked");
//    }



    //After Proxy---------------------------------------------------------------------------------
    //      //AfterReturning- It can alter the result returned by the method

//    @AfterReturning(value = "execution(com.springboot.spring_aop_02_proxies.Entities.Student " +
//            "com.springboot.spring_aop_02_proxies.Services..createStudent(..))",returning = "result")
//    public void logAfterReturningMethod(Student result){
//
//        System.out.println("Proxy AfterReturning Executed");
//
//        result.setId(1L);
//        result.setName("Aman");
//
//        System.out.println("Method Interprated");
//
//    }



    //AfterThrowing Proxy -----------------------------------------------------------------------
    //        // AfterThrowing- It Executes when service method throw exception
    //                          after -> after service method
    //                          throwing -> after throwing exception


//    @AfterThrowing(value = "execution(com.springboot.spring_aop_02_proxies.Entities.Student " +
//            "com.springboot.spring_aop_02_proxies.Services..createStudent(..))",
//    throwing = "exception")
//    public void logAfterThrowingMethod(Exception exception){
//        System.out.println("AfterThrowing Proxy Executed");
//        System.out.println("Exception Name:"+exception.getClass().getName());
//        System.out.println("Exception Message:"+exception.getMessage());
//    }


    //Around Proxy--------------------------------------------------------------------------------
    //        // Around Proxy- It is the most flexible proxy

    @Around(value = "execution(com.springboot.spring_aop_02_proxies.Entities.Student " +
            "com.springboot.spring_aop_02_proxies.Services..createStudent(..)))")
    public Object lofAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{

        System.out.println("Starting:"+joinPoint.getSignature().getName());  //-----@Before

        try{
            Object result = joinPoint.proceed();
            System.out.println("Execution Successful :"+result.toString());  //----@AFterReturning
            return result;
        }
        catch (Exception e){

            System.out.println("Exception Recieved :" + e.getMessage()); //-----@AfterThrowing
            throw e;
        }
        finally {

            System.out.println("Execution complete");  //----@After

        }
    }

}

package com.codegym.logg;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Aspect
public class LogAspect {

    @Pointcut("within(*com.codegym.controller.*)")
    public void findPointCut(){
    }

    @Before("findPointCut()")
    public void beforeCallAll(JoinPoint joinPoint){
        System.out.println("Start method name: " + joinPoint.getSignature().getName() + " Time: " + LocalDate.now());
    }

    @AfterReturning("findPointCut()")
    public void afterCallAll(JoinPoint joinPoint) {
        System.out.println("End method name: " + joinPoint.getSignature().getName() + " Time: " + LocalDate.now());
    }
}

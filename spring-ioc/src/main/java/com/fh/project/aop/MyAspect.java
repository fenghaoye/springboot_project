package com.fh.project.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {

    /*@Pointcut("execution(* com.fh.project.service.TestServiceImpl.*())")// the pointcut expression
    public void anyOldTransfer(){

    }*/
    @Pointcut("execution(* com.fh.project..*.*(..))")// the pointcut expression
    public void anyOldTransfer(){

    }

    @Before("com.fh.project.aop.MyAspect.anyOldTransfer()")
    public void doAccessCheck() {
        System.out.println("前置通知");
    }

   /* @Before("execution( * com.fh.project.*.*(..))")
    public void doAccessCheck() {
        System.out.println("前置通知");
    }*/
}

package com.aop.learning;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Audience {

    @Pointcut("execution(* hello(..))")
    public void performance() {

    }

    @Before("performance()")
    public void beforeLog() {
        System.out.println("before log......");
    }


 // around 是完全可以代替before和after的,下面定义的Around和afterReturning 同时存在就会编译报错
//    @AfterReturning(pointcut = "execution(* hello(String))"
//            +" && args(name)")
//    public void afterLog(String name) {
//        System.out.println("after log....."+name);
//    }


    @Around("execution(* hello(String))")
    public void around(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("around 开始执行");
            joinPoint.proceed();
            System.out.println("around 执行完成");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        ;
    }
}

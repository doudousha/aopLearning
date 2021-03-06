package com.aop.learning;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;


public class GreettingBeforeAdvice implements MethodBeforeAdvice {

    private int callNo = 0 ;

    public int getCallNo() {
        return callNo;
    }

    public void before(Method method, Object[] args, Object o) throws Throwable {
        String clientName =(String) args[0];
        System.out.println("How are you ! Mr."+ clientName+".");
        callNo+=1 ;
    }
}

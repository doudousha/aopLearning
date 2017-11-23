package com.aop.learning;


import org.springframework.stereotype.Component;

@Component
public class Teacher {

    public void hello(String name) {
        System.out.println("teacher say hello to "+ name);
    }

}

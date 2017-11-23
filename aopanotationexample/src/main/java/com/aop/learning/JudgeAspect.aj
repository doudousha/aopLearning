package com.aop.learning;

import org.springframework.stereotype.Component;

public aspect JudgeAspect{

    public JudgeAspect() {
    }


    private CriticismEngine  criticismEngine ;

    pointcut performance():execution(* hello(..));

    after() returning():performance(){
        System.out.println("performance: " +criticismEngine.getCriticism());
    }

    public void setCriticismEngine(CriticismEngine criticismEngine) {
        this.criticismEngine = criticismEngine;
    }
}
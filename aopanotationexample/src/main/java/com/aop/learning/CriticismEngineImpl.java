package com.aop.learning;

public class CriticismEngineImpl implements  CriticismEngine {

    private String[] criticismPool;

    public String getCriticism() {

        int i = (int) (Math.random() * criticismPool.length);
        return criticismPool[i];
    }

    public void setCriticismPool(String[] criticismPool) {
        this.criticismPool = criticismPool;
    }
}

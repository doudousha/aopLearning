package com.spring.audience;


import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 观看表演观众
 */
public class Audience {

    public void takeSeats() {
        System.out.println("表演之前");
    }

    public void turnOffCellPhones() {
        System.out.println("表演之前");
    }

    public void applaud() {
        System.out.println("表演之后");
    }

    public void demandRefund() {
        System.out.println("表演失败之后");
    }

    public void watcherPerformance(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕： 表演之前");

        try {
            long start = System.currentTimeMillis();
            joinPoint.proceed();
            long end = System.currentTimeMillis();
            System.out.println("环绕: 方法共执行:" + (end - start));
            System.out.println("表演结束");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("表演失败");
        }
    }
}

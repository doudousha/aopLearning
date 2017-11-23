package com.aop.learning;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.aop.framework.ProxyFactory;

public class AfterAdviceTest {

        private Waiter target ;
        private GreetingAfterAdvice advice ;
        private ProxyFactory pf ;

        @Before
        public void init() {
            target =  new NaiveWaiter();
            advice =  new GreetingAfterAdvice();
            // 提供的代理工厂
            pf =  new ProxyFactory();
            // 设置代理目标
            pf.setTarget(target);
            // 为代理目标添加增强
            pf.addAdvice(advice);
        }

        @Test
        public void beforeAdvice() {
            Waiter proxy =  (Waiter)pf.getProxy();
            proxy.greetTo("John");
            Assert.assertEquals(1,advice.getCallNo());
            proxy.serveTo("Tom");
            Assert.assertEquals(2,advice.getCallNo());
        }
}

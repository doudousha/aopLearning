package simpleaspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TracingAspect {

    private boolean enteringCalled = false;

    private Logger logger = LoggerFactory.getLogger(TracingAspect.class);

    public boolean isEnteringCalled() {
        return enteringCalled;
    }

    //@Before("execution( void doSomething() )")
    @Before("execution(* *(..))")
    public void entering(JoinPoint joinPoint) {
        enteringCalled = true;

        logger.trace("entering"
                + joinPoint.getStaticPart().getSignature().toString());

    }
//
//    @Before("execution( void doSomething() )")
//    public void entering2(JoinPoint joinPoint) {
//        enteringCalled = true;
//
//        logger.trace("entering"
//                + joinPoint.getStaticPart().getSignature().toString());
//
//    }
}



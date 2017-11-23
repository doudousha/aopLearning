package advicedeepdive;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AfterAdvice {

    private boolean afterCalled = false;

    private Logger logger = LoggerFactory.getLogger(AfterAdvice.class);

    public boolean isAfterCalled() {
        return afterCalled;
    }

    public void rest() {

    }

    @After("execution(* *(..))")
    public void exiting(JoinPoint joinPoint) {
        afterCalled = true;

        logger.trace("exiting"
                + joinPoint.getSignature());

        for (Object arg : joinPoint.getArgs()) {
            logger.trace("Arg : " + arg);
        }
    }
}

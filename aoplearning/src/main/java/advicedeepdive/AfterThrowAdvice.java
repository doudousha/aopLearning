package advicedeepdive;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class AfterThrowAdvice {

    private Logger logger = LoggerFactory.getLogger(AfterThrowAdvice.class);

    private boolean afterThrowsCalled = false;

    public void reset() {

        afterThrowsCalled = false;
    }

    public boolean isAfterThrowsCalled() {
        return afterThrowsCalled;
    }


    @AfterThrowing(pointcut="execution(void throwsRuntimeException())",throwing = "ex")
    public void logException(RuntimeException ex) {

        afterThrowsCalled=true ;
        logger.trace("Exception ",ex);
    }
}

package advicedeepdive;


import configuration.AdviceDeepDiveConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AdviceDeepDiveConfiguration.class)
public class AfterReturningAdviceTest {

    private Logger logger = LoggerFactory.getLogger(AfterReturningAdviceTest.class);
    @Autowired
    private AfterReturningAdvice afterReturningAdvice;

    @Autowired
    private SimpleService simpleService;

    @Before
    public void reset() {
        afterReturningAdvice.reset();
    }

    @Test
    public void afterReturningIsNotCalledIfReturnTypeDoesntMatch() {
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
        simpleService.returnsInt();
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
    }

    @Test
    public void afterReturningIsNotCalledIfExceptionIsThrown() {
        assertFalse(afterReturningAdvice.isAfterReturningCalled());

        try {
            simpleService.returnsStringAndThrowsRuntimeException();
        } finally {
            assertFalse(afterReturningAdvice.isAfterReturningCalled());
        }
    }

    @Test
    public void afterReturningIsCalledIfReturnTypeMatches() {
        assertFalse(afterReturningAdvice.isAfterReturningCalled());
        simpleService.returnsString();
        assertTrue(afterReturningAdvice.isAfterReturningCalled());
    }
}

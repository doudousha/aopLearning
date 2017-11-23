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
public class AfterThrowingAdviceTest {

    @Autowired
    private SimpleService simpleService ;

    @Autowired
    private AfterThrowAdvice afterThrowAdvice ;

    private Logger logger = LoggerFactory.getLogger(AfterThrowingAdviceTest.class);

    @Before
    public void reset() {
        afterThrowAdvice.reset();
    }

    @Test(expected = RuntimeException.class)
    public void afterThrowingIsNotCalledIfMethodReturnSuccessfully() {
        logger.trace("输出：" + afterThrowAdvice.isAfterThrowsCalled());
        assertFalse(afterThrowAdvice.isAfterThrowsCalled());
        try {
            simpleService.throwsRuntimeException();
        } finally {
            assertTrue(afterThrowAdvice.isAfterThrowsCalled());
        }
    }

}

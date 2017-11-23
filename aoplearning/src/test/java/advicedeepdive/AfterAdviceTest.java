package advicedeepdive;


import configuration.AdviceDeepDiveConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AdviceDeepDiveConfiguration.class)
public class AfterAdviceTest {

    @Autowired
    private SimpleService simpleService ;

    @Autowired
    private AfterAdvice afterAdvice ;

    @Before
    public void reset() {
        afterAdvice.rest();
    }

    @Test(expected = RuntimeException.class)
    public void afterAspectIsCalledIfMethodThrwosException() {
        assertFalse(afterAdvice.isAfterCalled()) ;
        try {
            simpleService.throwsRuntimeException();
        } finally {
            assertTrue(afterAdvice.isAfterCalled());
        }
    }

}

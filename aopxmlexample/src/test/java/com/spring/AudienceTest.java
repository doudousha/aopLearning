package com.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")
public class AudienceTest {

    @Autowired
    @Qualifier("volunteer")
    private Thinker thinker;

    @Autowired
    private MindReader mindReader ;
    @Test
    public void test() {

        thinker.thinkOfSomething("Queen of Hearts");
       assertEquals("Queen of Hearts",mindReader.getThoughts());
    }

}

import com.aop.learning.CriticismEngine;
import com.aop.learning.Teacher;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/beans.xml")

public class CriticismEngineTest {



    @Autowired
    private Teacher teacher ;

    public void test() {

        teacher.hello("小明");
    }

}

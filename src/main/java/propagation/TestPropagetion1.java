package propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component("testPropagation1")
public class TestPropagetion1 {
    @Autowired
    private JdbcTemplate jdbc;
    @Autowired
    private TestPropagetion2 test2;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("propagation.xml");
        TestPropagetion1 test1 = ctx.getBean("testPropagation1", TestPropagetion1.class);
        //test1.testNOT_SUPPORTED();
        //test1.testNEVER();
        test1.testNESTED();
    }

    //@Transactional(propagation = Propagation.REQUIRED)
    public void testREQUIRED() {
        String sql = "insert into propagation(name) values('REQUIRED1')";
        jdbc.execute(sql);
        test2.testREQUIRED(false);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testSUPPORTS() {
        String sql = "insert into propagation(name) values('SUPPORTS')";
        jdbc.execute(sql);
        test2.testSUPPORTS(true);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testMANDATORY() {
        String sql = "insert into propagation(name) values('MANDATORY2')";
        jdbc.execute(sql);
        test2.testMANDATORY(true);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testREQUIRES_NES() {
        String sql = "insert into propagation(name) values('MANDATORY2')";
        jdbc.execute(sql);
        test2.testREQUIRES_NEW(true);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testNOT_SUPPORTED() {
        String sql = "insert into propagation(name) values('MANDATORY2')";
        jdbc.execute(sql);
        test2.testNOT_SUPPORTED(true);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testNEVER() {
        String sql = "insert into propagation(name) values('NEVER1')";
        jdbc.execute(sql);
        test2.testNEVER(false);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testNESTED() {
        String sql = "insert into propagation(name) values('REQUIRED1')";
        jdbc.execute(sql);
        try {
            test2.testNESTED(true);
        } catch (Exception e) {

        }
        if (true) {
            throw new RuntimeException("NESTED2抛出异常");   //嵌套事务应该随父事件回滚
        }
    }
}

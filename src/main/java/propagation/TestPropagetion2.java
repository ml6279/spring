package propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class TestPropagetion2 {
    @Autowired
    private JdbcTemplate jdbc;

    @Transactional(propagation = Propagation.REQUIRED)
    public void testREQUIRED(boolean falg) {
        String sql = "insert into propagation(name) values('REQUIRED2')";
        jdbc.execute(sql);
        if (falg == true) {
            throw new RuntimeException("REQUIRED2异常抛出");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void testSUPPORTS(boolean falg) {
        String sql = "insert into propagation(name) values('SUPPORTS2')";
        jdbc.execute(sql);
        if (falg == true) {
            throw new RuntimeException("SUPPORTS2异常抛出");
        }
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void testMANDATORY(boolean falg) {
        String sql = "insert into propagation(name) values('MANDATORY2')";
        jdbc.execute(sql);
        if (falg == true) {
            throw new RuntimeException("MANDATORY2异常抛出");
        }
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testREQUIRES_NEW(boolean falg) {
        String sql = "insert into propagation(name) values('REQUIRES_NEW2')";
        jdbc.execute(sql);
        if (falg == true) {
            throw new RuntimeException("REQUIRES_NEW2异常抛出");
        }
    }

    /*@Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void testNot_SUPPORTED(boolean falg){
        String sql = "insert into propagation(name) values('REQUIRES_NEW2')";
        jdbc.execute(sql);
        if(falg == true){
            throw new RuntimeException("NOT_SUPPORTED2抛出异常");
        }
    }
*/
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void testNOT_SUPPORTED(boolean falg) {
        String sql = "insert into propagation(name) values('NOT_SUPPORTED2')";
        jdbc.execute(sql);
        if (falg == true) {
            throw new RuntimeException("NOT_SUPPORTED2抛出异常");
        }
    }

    @Transactional(propagation = Propagation.NEVER)
    public void testNEVER(boolean falg) {
        String sql = "insert into propagation(name) values('NEVER2')";
        jdbc.execute(sql);
        if (falg == true) {
            throw new RuntimeException("NEVER2抛出异常");
        }
    }

    @Transactional(propagation = Propagation.NESTED)
    public void testNESTED(boolean falg) {
        String sql = "insert into propagation(name) values('NESTED2')";
        jdbc.execute(sql);
        if (falg == true) {
            throw new RuntimeException("NESTED2抛出异常");
        }
    }
}

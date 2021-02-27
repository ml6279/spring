package annspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StaticDemo {
    private static Dao dao;    //静态属性不能直接注入,需要写方法注入

    @Autowired
    public void setter(Dao dao) {
        StaticDemo.dao = dao;
    }

    public void test() {
        dao.commit();
    }
}

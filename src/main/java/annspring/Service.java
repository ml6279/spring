package annspring;

import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service("service")
public class Service {
    @Autowired
    //@Qualifier("dao")
    private Dao dao;

    /*public Dao getDao() {
        return dao;
    }


    public void setDao(Dao dao) {
        this.dao = dao;
    }
*/
    /*@Autowired
    public void setter(@Qualifier("dao") Dao dao){
        this.dao = dao;
    }*/

    public Service() {
        System.out.println("service被创建");
    }

    public void service() {
        System.out.println("服务层调用数据层");
        dao.commit();
    }
}

package annspring;

import org.springframework.stereotype.Repository;

@Repository("dao")
/*@Repository*/
public class Dao {
    public void commit() {
        System.out.println("dao层数据提交");
    }
}

package springbatis.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import springbatis.dao.UserDao;
import springbatis.entity.NewsUser;
import springbatis.service.UserService;

import javax.annotation.Resource;


@Service("UserService")
//@Transactional //开启事务
public class UserServiceImpl implements UserService {
    @Resource(name = "UserDao")
    private UserDao dao;


    public UserDao getDao() {

        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public NewsUser getUser(String name, String password) {
        return dao.getUser(name, password);
    }

    @Override
    public void addUser(String name, String password) {
        NewsUser user = new NewsUser();
        user.setName(name);
        user.setPasseord(password);
        dao.insertUser(user);
    }

    //Transactional(rollbackFor = {SQLException.class},noRollbackFor = {RunTimeException.class})  遇到异常就抛出
    //readOnly: 默认未false 读写型 事务
    //事务传播级别 propagation = Propagation.REQUIRED
    @Transactional(rollbackFor = {Exception.class}, readOnly = false, propagation = Propagation.REQUIRED)
    @Override
    public void batchAddUser() {
        NewsUser user1 = new NewsUser();
        user1.setName("1");
        user1.setPasseord("1");
        NewsUser user2 = new NewsUser();
        user2.setName("2");
        user2.setPasseord("2");
        dao.insertUser(user1);
        dao.insertUser(user2);
        if (user1.getName().equals("1")) {
            throw new RuntimeException("测试事务");
        }
    }
}

package springbatis1.service.Impl;

import springbatis1.dao.UserDao;
import springbatis1.entity.NewsUser;
import springbatis1.service.UserService;

public class UserServiceImpl implements UserService {
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

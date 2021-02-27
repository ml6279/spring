package springbatis1.service;

import springbatis1.entity.NewsUser;

public interface UserService {
    public NewsUser getUser(String name, String password);

    public void addUser(String name, String password);

    public void batchAddUser();     //批量插入用户,为了测试事务
}

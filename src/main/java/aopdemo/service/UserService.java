package aopdemo.service;

import aopdemo.entity.User;

//核心业务
public class UserService {
    public boolean addUser(User user) {
        System.out.println("开始增加用户业务操作");
        if (!"凤姐".equals(user.getName())) {
            throw new RuntimeException("只能增加凤姐");
        }
        System.out.println("结束增加用户业务操作");
        return true;
    }
}

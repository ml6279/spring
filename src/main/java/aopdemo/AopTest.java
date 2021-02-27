package aopdemo;

import aopdemo.entity.User;
import aopdemo.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AopTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aopdemo.xml");
        User user = new User("凤姐", "123456");
        UserService service = (UserService) ctx.getBean("userService");
        service.addUser(user);
    }
}

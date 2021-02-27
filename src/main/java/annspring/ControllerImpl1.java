package annspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControllerImpl1 {
    @Autowired
    private Service service;

    public void web() {
        System.out.println("控制层调用服务层");
        service.service();
    }
}

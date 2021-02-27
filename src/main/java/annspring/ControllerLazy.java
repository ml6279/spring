package annspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Lazy(true) //懒加载
@Scope("prototype") //singleton
public class ControllerLazy {
    @Autowired
    private Service service;

    public void setService(Service service) {
        this.service = service;
    }

    public void web() {
        System.out.println("控制层调用服务层");
        service.service();
    }
}

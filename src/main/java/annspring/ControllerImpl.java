package annspring;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller("controller")
public class ControllerImpl {

    @Resource(name = "service")
    private Service service;

    public void setter(Service service) {
        this.service = service;
    }

    /* @Autowired
     public ControllerImpl(@Qualifier("service") Service service){
         this.service = service;
     }*/
    public void web() {
        System.out.println("控制层调用服务层");
        service.service();
    }
}

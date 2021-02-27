package annspring;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class Other {
    public Other() {
        System.out.println("构造方法");
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化......");
    }

    @PreDestroy
    public void destory() {
        System.out.println("销毁......");
    }
}

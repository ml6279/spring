package beans;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Other {
    private static final Logger LOG = LoggerFactory.getLogger(Other.class);

    public Other() {
        LOG.debug("实例化对象other");
    }

    public void init() {
        LOG.debug("调用初始化方法");
    }

    public void destory() {
        LOG.debug("调用销毁方法");
    }
}

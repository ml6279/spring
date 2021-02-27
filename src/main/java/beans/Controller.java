package beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller {
    private static final Logger LOG = LoggerFactory.getLogger(Controller.class);

    private Service service;

    public void controller() {
        LOG.debug("控制层......");
        service.service();
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}

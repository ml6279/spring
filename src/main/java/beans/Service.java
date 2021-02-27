package beans;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Service {
    private static final Logger LOG = LoggerFactory.getLogger(Service.class);

    private Dao dao;

    public void service() {
        LOG.debug("服务层");
        dao.dao();
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
}

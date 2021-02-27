package springbatis1.dao.Impl;

import org.mybatis.spring.SqlSessionTemplate;
import springbatis1.dao.UserDao;
import springbatis1.entity.NewsUser;

public class UserDaoImpl implements UserDao {
    private SqlSessionTemplate sqlSession;

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public NewsUser getUser(String name, String password) {
        return sqlSession.getMapper(UserDao.class).getUser(name, password);
    }

    @Override
    public void insertUser(NewsUser user) {
        sqlSession.getMapper(UserDao.class).insertUser(user);
    }
}

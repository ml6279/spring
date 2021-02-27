package springbatis.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import springbatis.entity.NewsUser;

@Repository("UserDao")
public interface UserDao {
    public NewsUser getUser(@Param("name") String name, @Param("password") String password);

    public void insertUser(NewsUser user);
}

package sww.stuinfo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sww.stuinfo.pojo.User;
import sww.stuinfo.pojo.UserInfo;



@Repository
@Mapper
public interface UserMapper {

    public User getUserByUsername(@Param("username") String username);

    public UserInfo getUserInfoByUsername(@Param("username") String username);

}

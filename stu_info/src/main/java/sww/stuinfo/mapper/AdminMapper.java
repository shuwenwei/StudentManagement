package sww.stuinfo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sww.stuinfo.pojo.RequestStudentInfo;
import sww.stuinfo.pojo.User;


@Mapper
@Repository
public interface AdminMapper {

    boolean deleteUser(@Param("username") String username);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean addStudentInfo(RequestStudentInfo requestStudentInfo);

}

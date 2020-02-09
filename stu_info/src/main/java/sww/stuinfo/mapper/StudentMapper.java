package sww.stuinfo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sww.stuinfo.pojo.StudentInfo;
import sww.stuinfo.pojo.UserInfo;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    public StudentInfo getStudentInfo(@Param("username") String username);

    public List<UserInfo> getClassmates(@Param("username") String username);

}

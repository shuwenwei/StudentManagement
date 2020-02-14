package sww.stuinfo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sww.stuinfo.pojo.Clazz;
import sww.stuinfo.pojo.FamilyMember;
import sww.stuinfo.pojo.UserInfo;

import java.util.List;


@Mapper
@Repository
public interface InstructorMapper {

    List<Clazz> getAllClazz(@Param("username") String username);

    boolean updateStudentInfo(UserInfo userInfo);

    boolean updateStudentFamilyInfo(FamilyMember familyMember);

    String getStudentInstructor(@Param("username") String username);

    List<UserInfo> findStudentByName(String name,String instructor);
}

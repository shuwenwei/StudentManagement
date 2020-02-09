package sww.stuinfo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sww.stuinfo.pojo.Institute;
import sww.stuinfo.pojo.Major;
import sww.stuinfo.pojo.RequestStudentInfo;
import sww.stuinfo.pojo.User;

import java.util.List;


@Mapper
@Repository
public interface AdminMapper {

    boolean deleteUser(@Param("username") String username);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean addStudentInfo(RequestStudentInfo requestStudentInfo);

    List<Institute> getAllInstitute();

    boolean updateInstitute(Institute institute);

    boolean addInstitute(Institute institute);

    boolean deleteInstitute(String id);

    List<Major> getAllMajor();

    boolean updateMajor(Major major);

    boolean addMajor(Major major);

    boolean deleteMajor(String id);
}

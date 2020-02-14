package sww.stuinfo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sww.stuinfo.pojo.*;

import java.util.List;


@Mapper
@Repository
public interface AdminMapper {

    boolean deleteUser(@Param("username") String username);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean addStudentInfo(RequestStudentInfo requestStudentInfo);

    List<Institute> getAllInstitute();

    Institute getInstitute(String id);

    boolean updateInstitute(Institute institute);

    boolean addInstitute(Institute institute);

    boolean deleteInstitute(String id);

    List<Major> getAllMajor();

    Major getMajor(String id);

    boolean updateMajor(Major major);

    boolean addMajor(Major major);

    boolean deleteMajor(String id);

    List<Clazz> getAllClazz();

    boolean updateClazz(Clazz clazz);

    boolean addClazz(Clazz clazz);

    boolean deleteClazz(String id);

    Clazz findClazzById(String id);

    boolean deleteUserInfo(String id);

    boolean updateStudentInfo(RequestStudentInfo requestStudentInfo);

    boolean deleteStudentInfo(String id);

    boolean addFamilyMember(FamilyMember familyMember);

    boolean deleteFamilyMember(String id);
}

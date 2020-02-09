package sww.stuinfo.service;

import sww.stuinfo.pojo.Clazz;
import sww.stuinfo.pojo.FamilyMember;
import sww.stuinfo.pojo.UserInfo;

import java.util.List;


public interface InstructorService {

    List<Clazz> getAllClazz(String username);

    boolean updateStudentInfo(UserInfo userInfo);

    boolean updateStudentFamilyInfo(FamilyMember familyMember);

    String getStudentInstructor(String username);

}

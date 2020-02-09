package sww.stuinfo.service;

import sww.stuinfo.pojo.Institute;
import sww.stuinfo.pojo.RequestStudentInfo;
import sww.stuinfo.pojo.User;

import java.util.List;

public interface AdminService {

    boolean deleteUser(String username);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean addStudentInfo(RequestStudentInfo requestStudentInfo);

    List<Institute> getAllInstitute();

    boolean updateInstitute(Institute institute);

    boolean addInstitute(Institute institute);

    boolean deleteInstitute(String id);

}

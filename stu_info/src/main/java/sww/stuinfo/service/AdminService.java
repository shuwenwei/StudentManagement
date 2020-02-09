package sww.stuinfo.service;

import sww.stuinfo.pojo.RequestStudentInfo;
import sww.stuinfo.pojo.User;

public interface AdminService {

    boolean deleteUser(String username);

    boolean addUser(User user);

    boolean updateUser(User user);

    boolean addStudentInfo(RequestStudentInfo requestStudentInfo);

}

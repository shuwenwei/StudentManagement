package sww.stuinfo.service;

import sww.stuinfo.pojo.StudentInfo;
import sww.stuinfo.pojo.UserInfo;

import java.util.List;

public interface StudentService {

    public StudentInfo getStudentInfo(String username);

    public List<UserInfo> getClassmates(String username);
}

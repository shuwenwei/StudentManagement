package sww.stuinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sww.stuinfo.mapper.StudentMapper;
import sww.stuinfo.pojo.StudentInfo;
import sww.stuinfo.pojo.UserInfo;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public StudentInfo getStudentInfo(String username) {
        return studentMapper.getStudentInfo(username);
    }

    @Override
    public List<UserInfo> getClassmates(String username) {
        return studentMapper.getClassmates(username);
    }
}

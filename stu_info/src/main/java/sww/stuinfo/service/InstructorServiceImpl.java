package sww.stuinfo.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sww.stuinfo.mapper.InstructorMapper;
import sww.stuinfo.pojo.Clazz;
import sww.stuinfo.pojo.FamilyMember;
import sww.stuinfo.pojo.UserInfo;

import java.util.List;


@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    InstructorMapper instructorMapper;

    @Override
    public List<Clazz> getAllClazz(String username) {
        return instructorMapper.getAllClazz(username);
    }

    @Override
    public boolean updateStudentInfo(UserInfo userInfo) {
        return instructorMapper.updateStudentInfo(userInfo);
    }

    @Override
    public boolean updateStudentFamilyInfo(FamilyMember familyMember) {
        return instructorMapper.updateStudentFamilyInfo(familyMember);
    }

    @Override
    public String getStudentInstructor(String username) {
        return instructorMapper.getStudentInstructor(username);
    }

    @Override
    public List<UserInfo> findStudentByName(String name, String instructor, int page) {
        name = "%" + name + "%";
        PageHelper.startPage(1,10);
        return instructorMapper.findStudentByName(name,instructor);
    }
}

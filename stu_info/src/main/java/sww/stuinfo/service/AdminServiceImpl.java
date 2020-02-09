package sww.stuinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sww.stuinfo.mapper.AdminMapper;
import sww.stuinfo.pojo.RequestStudentInfo;
import sww.stuinfo.pojo.User;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public boolean deleteUser(String username) {
        return adminMapper.deleteUser(username);
    }

    @Override
    public boolean addUser(User user) {
        return adminMapper.addUser(user);
    }

    @Override
    public boolean updateUser(User user) {
        return adminMapper.updateUser(user);
    }

    @Override
    public boolean addStudentInfo(RequestStudentInfo requestStudentInfo) {
        return adminMapper.addStudentInfo(requestStudentInfo);
    }

}

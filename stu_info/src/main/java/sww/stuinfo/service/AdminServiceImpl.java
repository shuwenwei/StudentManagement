package sww.stuinfo.service;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sww.stuinfo.mapper.AdminMapper;
import sww.stuinfo.pojo.*;

import java.util.List;

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

    @Override
    public List<Institute> getAllInstitute() {
        return adminMapper.getAllInstitute();
    }

    @Override
    public boolean updateInstitute(Institute institute) {
        return adminMapper.updateInstitute(institute);
    }

    @Override
    public boolean addInstitute(Institute institute) {
        return adminMapper.addInstitute(institute);
    }

    @Override
    public boolean deleteInstitute(String id) {
        return adminMapper.deleteInstitute(id);
    }

    @Override
    public List<Major> getAllMajor(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        return adminMapper.getAllMajor();
    }

    @Override
    public boolean updateMajor(Major major) {
        return adminMapper.updateMajor(major);
    }

    @Override
    public boolean addMajor(Major major) {
        return adminMapper.addMajor(major);
    }

    @Override
    public boolean deleteMajor(String id) {
        return adminMapper.deleteMajor(id);
    }

    @Override
    public List<Clazz> getAllClazz(int pageNumber, int pageSize) {
        PageHelper.startPage(pageNumber,pageSize);
        return adminMapper.getAllClazz();
    }

    @Override
    public boolean updateClazz(Clazz clazz) {
        return adminMapper.updateClazz(clazz);
    }

    @Override
    public boolean addClazz(Clazz clazz) {
        return adminMapper.addClazz(clazz);
    }

    @Override
    public boolean deleteClazz(String id) {
        return adminMapper.deleteClazz(id);
    }

}

package sww.stuinfo.service;

import sww.stuinfo.pojo.*;

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

    List<Major> getAllMajor(int pageNumber, int pageSize);

    boolean updateMajor(Major major);

    boolean addMajor(Major major);

    boolean deleteMajor(String id);

    List<Clazz> getAllClazz(int pageNumber, int pageSize);

    boolean updateClazz(Clazz clazz);

    boolean addClazz(Clazz clazz);

    boolean deleteClazz(String id);

    Clazz findClazzById(String id);

}

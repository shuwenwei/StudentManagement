package sww.stuinfo.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sww.stuinfo.exception.*;
import sww.stuinfo.pojo.*;
import sww.stuinfo.service.AdminService;
import sww.stuinfo.service.InstructorService;
import sww.stuinfo.service.StudentService;
import sww.stuinfo.service.UserService;
import sww.stuinfo.utils.CheckBindingUtil;
import sww.stuinfo.utils.PasswordUtils;

import javax.validation.Valid;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;


@RestController
@RequiresRoles("admin")
public class AdminController {

    private AdminService adminService;
    private InstructorService instructorService;
    private UserService userService;
    private StudentService studentService;

    @Autowired
    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Autowired
    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/institute/{id}")
    public DefaultResponseBean getInstitute(@PathVariable String id) {
        Institute institute = adminService.getInstitute(id);
        if (institute != null) {
            return new DefaultResponseBean(" 获取成功",institute,1);
        }else {
            throw new InvalidFieldException();
        }
    }

    @PutMapping("/institute")
    public DefaultResponseBean updateInstitute(@RequestBody @Valid Institute institute, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        if (adminService.updateInstitute(institute)) {
            return new DefaultResponseBean("修改成功",null,1);
        }else {
            throw new InvalidFieldException();
        }
    }

    @GetMapping("/institute")
    public DefaultResponseBean getAllInstitutes(){
        List<Institute> institutes = adminService.getAllInstitute();
        return new DefaultResponseBean("获取成功",institutes,1);
    }

    @PostMapping("/institute")
    public DefaultResponseBean addInstitute(@RequestBody @Valid Institute institute, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        if (adminService.addInstitute(institute)) {
            return new DefaultResponseBean("添加成功", null, 1);
        }else {
            throw new InvalidFieldException();
        }
    }

    @DeleteMapping("/institute/{id}")
    public DefaultResponseBean deleteInstitute(@PathVariable String id) {
        try {
            adminService.deleteInstitute(id);
        }catch (Exception e){
            throw new DeleteFailedException("无法删除非空的学院");
        }
        return new DefaultResponseBean("删除成功", null, 1);
    }


    @PutMapping("/major")
    public DefaultResponseBean updateMajor(@RequestBody @Valid Major major, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        if (adminService.updateMajor(major)) {
            return new DefaultResponseBean("修改成功",null,1);
        }else {
            throw new InvalidFieldException();
        }
    }

    @GetMapping("/major/{page}")
    public DefaultResponseBean getAllMajors(@PathVariable int page){
        List<Major> majors = adminService.getAllMajor(page,10);
        return new DefaultResponseBean("获取成功",majors,1);
    }

    @PostMapping("/major")
    public DefaultResponseBean addMajor(@RequestBody @Valid Major major, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        try {
            adminService.addMajor(major);
        }catch (Exception e) {
            throw new IllegalPropertyException("属性错误");
        }
        return new DefaultResponseBean("添加成功", null, 1);
//        if (adminService.addMajor(major)) {
//            return new DefaultResponseBean("添加成功", null, 1);
//        }else {
//            throw new InvalidFieldException();
//        }
    }

    @DeleteMapping("/major/{id}")
    public DefaultResponseBean deleteMajor(@PathVariable String id) {
        try {
            adminService.deleteMajor(id);
        }catch (Exception e){
            throw new DeleteFailedException("无法删除非空的专业");
        }
        return new DefaultResponseBean("删除成功", null, 1);
    }

    @GetMapping("/class/{pageNumber}")
    public DefaultResponseBean getAllClazz(@PathVariable int pageNumber) {
        List<Clazz> pageClazz = adminService.getAllClazz(pageNumber, 10);
        return new DefaultResponseBean("获取成功",pageClazz,1);
    }

    @GetMapping("/class")
    public DefaultResponseBean getClazz(@RequestParam String id) {
        Clazz clazz = adminService.findClazzById(id);
        if (clazz != null) {
            return new DefaultResponseBean("获取成功", clazz, 1);
        }else {
            throw new IllegalPropertyException("班级不存在");
        }
    }

    @PutMapping("/class")
    public DefaultResponseBean updateClazz(@RequestBody @Valid Clazz clazz, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        if (adminService.updateClazz(clazz)) {
            return new DefaultResponseBean("更新成功",null,1);
        }else {
            throw new InvalidFieldException();
        }
    }

    @PostMapping("/class")
    public DefaultResponseBean addClazz(@RequestBody @Valid Clazz clazz, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        try {
            adminService.addClazz(clazz);
        }catch (RuntimeException e) {
            throw new InvalidFieldException();
        }
        return new DefaultResponseBean("添加成功",null,1);
    }

    @DeleteMapping("/class/{id}")
    public DefaultResponseBean deleteClazz(@PathVariable String id) {
        if (adminService.deleteClazz(id)) {
            return new DefaultResponseBean("删除成功",null,1);
        }else {
            throw new InvalidFieldException();
        }
    }


//---------------------------------------------------------------------------------
//---------------------------------------------------------------------------------
    @DeleteMapping("/user/{username}")
    public DefaultResponseBean deleteUser(@PathVariable String username) {
        if (adminService.deleteUser(username)) {
            return new DefaultResponseBean("删除成功",null,1);
        }else {
            throw new UserNotExistException();
        }
    }

    @PostMapping("/user")
    public DefaultResponseBean addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        user.setPassword(PasswordUtils.generate(user.getPassword()));
        try {
            adminService.addUser(user);
        }catch (Exception e){
            throw new UsernameExistException();
        }
        return new DefaultResponseBean("添加成功",null,1);
    }

    @PutMapping("/user")
    public DefaultResponseBean updateUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        if (user.getPassword() != null) {
            user.setPassword(PasswordUtils.generate(user.getPassword()));
        }
        if (adminService.updateUser(user)) {
            return new DefaultResponseBean("修改成功",null,1);
        }else {
            throw new UserNotExistException();
        }
    }



//    @GetMapping("/admin/userinfo/{id}")
//    public DefaultResponseBean findUserInfoById(@PathVariable String id) {
//        UserInfo userInfo = userService.getUserInfoByUsername(id);
//        return new DefaultResponseBean("获取成功",userInfo,1);
//    }

    @PutMapping("/user/info")
    public DefaultResponseBean updateUserInfo(@RequestBody @Valid UserInfo userInfo, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        if (instructorService.updateStudentInfo(userInfo)) {
            return new DefaultResponseBean("修改成功",null,1);
        }else {
            throw new InvalidFieldException();
        }
    }

    @GetMapping("/user/info/{username}")
    public DefaultResponseBean getUserInfo(@PathVariable String username){
        UserInfo userInfo = userService.getUserInfoByUsername(username);
        if (userInfo != null) {
            return new DefaultResponseBean("获取成功",userInfo,1);
        }else {
            throw new UserNotExistException();
        }
    }

    @DeleteMapping("/user/info/{id}")
    public DefaultResponseBean deleteUserInfo(@PathVariable String id) {
        if (adminService.deleteUserInfo(id)) {
            return new DefaultResponseBean("删除成功",null,1);
        }else {
            throw new UserNotExistException();
        }
    }



    @GetMapping("/admin/student/{id}")
    public DefaultResponseBean findStudentInfoById(@PathVariable String id) {
        StudentInfo studentInfo = studentService.getStudentInfo(id);
        return new DefaultResponseBean("获取成功",studentInfo,1);
    }

    @PostMapping("/admin/student")
    public DefaultResponseBean addStudentInfo(@RequestBody RequestStudentInfo requestStudentInfo, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        try {
            adminService.addStudentInfo(requestStudentInfo);
        }catch (Exception e){
            throw new InvalidFieldException();
        }
        return new DefaultResponseBean("添加成功",null,1);
    }

    @PutMapping("/admin/student")
    public DefaultResponseBean updateStudentInfo(@RequestBody @Valid RequestStudentInfo requestStudentInfo, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        if (adminService.updateStudentInfo(requestStudentInfo)) {
            return new DefaultResponseBean("修改成功",null,1);
        }else {
            throw new InvalidFieldException();
        }
    }

    @DeleteMapping("/admin/student/{id}")
    public DefaultResponseBean deleteStudentInfo(@PathVariable String id) {
        if (adminService.deleteStudentInfo(id)) {
            return new DefaultResponseBean("删除成功",null,1);
        }else {
            throw new UserNotExistException();
        }
    }

    @PutMapping("/family")
    public DefaultResponseBean updateFamilyMemberInfo(@RequestBody @Valid FamilyMember familyMember, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        if (instructorService.updateStudentFamilyInfo(familyMember)) {
            return new DefaultResponseBean("修改成功",null,1);
        }else {
            throw new InvalidFieldException();
        }
    }

    @PostMapping("/family")
    public DefaultResponseBean addFamilyMemberInfo(@RequestBody @Valid FamilyMember familyMember, BindingResult bindingResult) {
        CheckBindingUtil.checkBinding(bindingResult);
        try {
            adminService.addFamilyMember(familyMember);
        }catch (RuntimeException e) {
            throw new InvalidFieldException();
        }
        return new DefaultResponseBean("添加成功",null,1);
    }

    @DeleteMapping("/family/{id}")
    public DefaultResponseBean deleteFamilyMemberInfo(@PathVariable String id) {
        if (adminService.deleteFamilyMember(id)) {
            return new DefaultResponseBean("删除成功",null,1);
        }else {
            throw new DeleteFailedException("成员不存在");
        }
    }

    @GetMapping("/admin/userinfo")
    public DefaultResponseBean findUserByName(@RequestParam String name, @RequestParam int page) {
        List<UserInfo> users = adminService.findUserByName(name);
        if (!users.isEmpty()) {
            return new DefaultResponseBean("获取成功",null,1);
        }else {
            throw new UserNotExistException();
        }
    }

}
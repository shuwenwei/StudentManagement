package sww.stuinfo.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sww.stuinfo.exception.IllegalPropertyException;
import sww.stuinfo.exception.InvalidFieldException;
import sww.stuinfo.exception.UserNotExistException;
import sww.stuinfo.exception.UsernameExistException;
import sww.stuinfo.pojo.*;
import sww.stuinfo.service.AdminService;
import sww.stuinfo.service.InstructorService;
import sww.stuinfo.service.UserService;
import sww.stuinfo.utils.PasswordUtils;

import javax.validation.Valid;


@RestController
public class AdminController {

    private AdminService adminService;
    private InstructorService instructorService;
    private UserService userService;

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

    @RequiresRoles("admin")
    @DeleteMapping("/user/{username}")
    public DefaultResponseBean deleteUser(@PathVariable String username) {
        if (adminService.deleteUser(username)) {
            return new DefaultResponseBean("删除成功",null,1);
        }else {
            throw new UserNotExistException();
        }
    }

    @RequiresRoles("admin")
    @PostMapping("/user")
    public DefaultResponseBean addUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            throw new IllegalPropertyException(message);
        }
        user.setPassword(PasswordUtils.generate(user.getPassword()));
        try {
            adminService.addUser(user);
        }catch (Exception e){
            throw new UsernameExistException();
        }
        return new DefaultResponseBean("添加成功",null,1);
    }

    @RequiresRoles("admin")
    @PutMapping("/user")
    public DefaultResponseBean updateUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            throw new IllegalPropertyException(message);
        }
        if (user.getPassword() != null) {
            user.setPassword(PasswordUtils.generate(user.getPassword()));
        }
        if (adminService.updateUser(user)) {
            return new DefaultResponseBean("修改成功",null,1);
        }else {
            throw new UserNotExistException();
        }
    }

    @RequiresRoles("admin")
    @PutMapping("/user/info")
    public DefaultResponseBean updateUserInfo(@RequestBody @Valid UserInfo userInfo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            throw new IllegalPropertyException(message);
        }
        if (instructorService.updateStudentInfo(userInfo)) {
            return new DefaultResponseBean("修改成功",null,1);
        }else {
            throw new InvalidFieldException();
        }
    }

    @RequiresRoles("admin")
    @PutMapping("/family")
    public DefaultResponseBean updateFamilyMemberInfo(@RequestBody @Valid FamilyMember familyMember, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            throw new IllegalPropertyException(message);
        }
        if (instructorService.updateStudentFamilyInfo(familyMember)) {
            return new DefaultResponseBean("修改成功",null,1);
        }else {
            throw new InvalidFieldException();
        }
    }

    @RequiresRoles("admin")
    @GetMapping("/user/info/{username}")
    public DefaultResponseBean getUserInfo(@PathVariable String username){
        UserInfo userInfo = userService.getUserInfoByUsername(username);
        if (userInfo != null) {
            return new DefaultResponseBean("获取成功",userInfo,1);
        }else {
            throw new UserNotExistException();
        }
    }

    @RequiresRoles("admin")
    @PostMapping("/user/stu_info")
    public DefaultResponseBean addStudentInfo(@RequestBody RequestStudentInfo requestStudentInfo){
        try {
            adminService.addStudentInfo(requestStudentInfo);
        }catch (Exception e){
            throw new InvalidFieldException();
        }
        return new DefaultResponseBean("添加成功",null,1);
    }

}
package sww.stuinfo.controller;


import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sww.stuinfo.exception.InvalidTokenException;
import sww.stuinfo.exception.LoginFailedException;
import sww.stuinfo.exception.UserNotExistException;
import sww.stuinfo.pojo.DefaultResponseBean;
import sww.stuinfo.pojo.StudentInfo;
import sww.stuinfo.pojo.User;
import sww.stuinfo.pojo.UserInfo;
import sww.stuinfo.service.StudentService;
import sww.stuinfo.service.UserService;
import sww.stuinfo.utils.JWTUtils;
import sww.stuinfo.utils.PasswordUtils;

import java.util.List;


@RestController
public class UserController {

    private UserService userService;
    private StudentService studentService;

    @Autowired
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/token")
    public DefaultResponseBean login(@RequestBody User user) throws RuntimeException {
        User userInDB = userService.getUserByUsername(user.getUsername());
        if (userInDB == null){
            throw new UserNotExistException();
        }
        if (PasswordUtils.verify(user.getPassword(),userInDB.getPassword())) {
            String token = JWTUtils.generateToken(userInDB);
            return new DefaultResponseBean("登录成功",token,1);
        }else {
            throw new LoginFailedException();
        }
    }

    @GetMapping("/user/info")
    public DefaultResponseBean getSelfInfo(){
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        UserInfo userInfo = userService.getUserInfoByUsername(username);
        if (userInfo == null){
            throw new UserNotExistException();
        }
        return new DefaultResponseBean("获取成功",userInfo,1);
    }

    @GetMapping("/student/info")
    public DefaultResponseBean getSelfStuInfo(){
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        StudentInfo studentInfo = studentService.getStudentInfo(username);
        if (studentInfo == null){
            throw new UserNotExistException();
        }
        return new DefaultResponseBean("获取成功",studentInfo,1);
    }

    @GetMapping("/student/classmates")
    public DefaultResponseBean getClassmates(){
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        List<UserInfo> classmates = studentService.getClassmates(username);
        return new DefaultResponseBean("获取成功",classmates,1);
    }

}

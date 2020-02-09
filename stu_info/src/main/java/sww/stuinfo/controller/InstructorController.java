package sww.stuinfo.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sww.stuinfo.exception.IllegalPropertyException;
import sww.stuinfo.exception.InvalidFieldException;
import sww.stuinfo.exception.UserNotExistException;
import sww.stuinfo.pojo.Clazz;
import sww.stuinfo.pojo.DefaultResponseBean;
import sww.stuinfo.pojo.FamilyMember;
import sww.stuinfo.pojo.UserInfo;
import sww.stuinfo.service.InstructorService;
import sww.stuinfo.service.UserService;
import sww.stuinfo.utils.CheckBindingUtil;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiresRoles("instructor")
public class InstructorController {

    private InstructorService instructorService;
    private UserService userService;

    @Autowired
    public void setInstructorService(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/instructor/clazz")
    public DefaultResponseBean getClazz(){
        String username = SecurityUtils.getSubject().getPrincipal().toString();
        List<Clazz> clazzList = instructorService.getAllClazz(username);
        return new DefaultResponseBean("获取成功",clazzList,1);
    }

    @PutMapping("/instructor/student/info")
    public DefaultResponseBean updateStudentUserInfo(@RequestBody @Valid UserInfo userInfo, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()){
//            String message = bindingResult.getFieldError().getDefaultMessage();
//            throw new IllegalPropertyException(message);
//        }
        CheckBindingUtil.checkBinding(bindingResult);
//        该辅导员的username
        String instructorUsername = SecurityUtils.getSubject().getPrincipal().toString();
//        该学生的辅导员username
        String result = instructorService.getStudentInstructor(userInfo.getUsername());
        if (instructorUsername.equals(result)){
            if (instructorService.updateStudentInfo(userInfo)) {
                return new DefaultResponseBean("修改成功",null,1);
            }else {
                throw new InvalidFieldException();
            }
        }else {
            throw new ShiroException();
        }
    }

    @GetMapping("/instructor/student/info/{username}")
    public DefaultResponseBean getStudentUserInfo(@PathVariable String username){
        String instructorUsername = SecurityUtils.getSubject().getPrincipal().toString();
        String result = instructorService.getStudentInstructor(username);
        if (instructorUsername.equals(result)) {
            UserInfo userInfo = userService.getUserInfoByUsername(username);
            if (userInfo == null){
                throw new UserNotExistException();
            }
            return new DefaultResponseBean("获取成功",userInfo,1);
        }else {
            throw new ShiroException();
        }
    }

    @PutMapping("/instructor/student/family/{studentUsername}")
    public DefaultResponseBean updateStudentFamily(@PathVariable String studentUsername, @RequestBody @Valid FamilyMember familyMember,BindingResult bindingResult) {
//        if (bindingResult.hasErrors()){
//            String message = bindingResult.getFieldError().getDefaultMessage();
//            throw new IllegalPropertyException(message);
//        }
        CheckBindingUtil.checkBinding(bindingResult);
        String instructorUsername = SecurityUtils.getSubject().getPrincipal().toString();
        String result = instructorService.getStudentInstructor(studentUsername);
        if (instructorUsername.equals(result)){
            if (instructorService.updateStudentFamilyInfo(familyMember)) {
                return new DefaultResponseBean("修改成功",null,1);
            }else {
                throw new InvalidFieldException();
            }
        }else {
            throw new ShiroException();
        }
    }

}

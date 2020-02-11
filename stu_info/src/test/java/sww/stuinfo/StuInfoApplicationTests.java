package sww.stuinfo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sww.stuinfo.pojo.*;
import sww.stuinfo.service.AdminService;
import sww.stuinfo.service.InstructorService;
import sww.stuinfo.service.StudentService;
import sww.stuinfo.service.UserService;
import java.util.List;


@SpringBootTest
class StuInfoApplicationTests {

    @Autowired
    UserService userService;

    @Autowired
    StudentService studentService;

    @Autowired
    InstructorService instructorService;

    @Autowired
    AdminService adminService;

    @Test
    void contextLoads() {
        test5();
    }

    @Test
    void test1(){
        UserInfo userInfo = userService.getUserInfoByUsername("6104119052");
        System.out.println(userInfo);
    }

    @Test
    void test2(){
        StudentInfo studentInfo = studentService.getStudentInfo("6104119052");
        System.out.println(studentInfo);
    }

    @Test
    void test3(){
        List<UserInfo> classmates = studentService.getClassmates("6104119052");
        for (UserInfo classmate : classmates) {
            System.out.println(classmate);
        }
    }

    @Test
    void test4(){
        List<Clazz> clazzes = instructorService.getAllClazz("6104119053");
        for (Clazz clazz : clazzes) {
            System.out.println(clazz);
        }
    }

    @Test
    void test5(){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("6104119052");
        userInfo.setProvince("jiangxi");
        userInfo.setCity("xiny");
        instructorService.updateStudentInfo(userInfo);
    }

    @Test
    void test6(){
        FamilyMember familyMember = new FamilyMember();
        familyMember.setId("1");
        familyMember.setName("1aaaaa");
        instructorService.updateStudentFamilyInfo(familyMember);
    }

    @Test
    void test7(){
        System.out.println(adminService.deleteUser("6104119058"));
    }

    @Test
    void test8(){
        User user = new User();
        user.setUsername("6104119058");
        user.setPassword("111111");
        user.setRole("instructor");
        boolean flag = adminService.addUser(user);
        System.out.println(flag);
    }

    @Test
    void test9(){
        RequestStudentInfo info = new RequestStudentInfo();
        info.setClassId("1");
        info.setInstituteId("1");
        info.setMajorId("1");
        info.setUsername("6104119057");
        info.setInstructorId("6104119053");
        adminService.addStudentInfo(info);
    }

    @Test
    public void test10(){
        Institute institute = new Institute();
        institute.setId("1");
        institute.setName("信息工程学院1");
        boolean flag = adminService.updateInstitute(institute);
        System.out.println(flag);
    }

    @Test
    void test11(){
        List<Clazz> allClazz = adminService.getAllClazz(1, 5);
        for (Clazz clazz : allClazz) {
            System.out.println(clazz);
        }
    }
}

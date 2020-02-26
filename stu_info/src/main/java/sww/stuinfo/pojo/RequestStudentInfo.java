package sww.stuinfo.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

@Data
public class RequestStudentInfo {
    @Pattern(regexp = "^[0-9]{10}$", message = "用户名为10位数字")
    private String username;
    private String classId;
    @Null
    private String instructorId;
    @Null
    private String instituteId;
    @Null
    private String majorId;
}

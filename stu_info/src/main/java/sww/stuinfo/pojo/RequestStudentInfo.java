package sww.stuinfo.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class RequestStudentInfo {
    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "^[0-9]{10}$", message = "用户名为10位数字")
    private String username;
    private String classId;
    private String instructorId;
    private String instituteId;
    private String majorId;
}

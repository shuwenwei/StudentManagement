package sww.stuinfo.pojo;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Data
@ToString
public class User {
    @NotBlank(message = "用户名不能为空")
    @Pattern(regexp = "^[0-9]{10}$", message = "用户名为10位数字")
    private String username;
    @Pattern(regexp = "^[A-Za-z0-9]{6,20}$", message = "密码必须为字母或数字,长度6-20")
    private String password;
    private String role;

}

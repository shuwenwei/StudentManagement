package sww.stuinfo.pojo;

import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@ToString
public class UserInfo {

    @NotBlank
    @Size(min = 10,max = 10,message = "username格式错误")
    private String username;
    private String name;
    private String sex;
    @Pattern(regexp = "^((13[0-9])|(15[^4,\\\\D])|(18[0,5-9]))\\\\d{8}$",
    message = "手机号格式错误")
    private String telephone;
    private String qq;
    private String weChat;
    private String idCard;
    private String province;
    private String city;
    private String address;
    private List<FamilyMember> familyMembers;
}

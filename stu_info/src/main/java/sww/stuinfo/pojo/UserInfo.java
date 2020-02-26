package sww.stuinfo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserInfo {

    @NotBlank
    @Size(min = 10,max = 10,message = "username格式错误")
    private String username;
    private String name;
    private String sex;
    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$",
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

package sww.stuinfo.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class FamilyMember {

    @NotBlank(message = "id不能为空")
    private String id;
    private String studentUsername;
    private String name;
    private String relation;
    private String job;
    private String telephone;
}

package sww.stuinfo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class FamilyMember {

    @NotBlank(message = "id不能为空")
    private String id;
    private String studentUsername;
    private String name;
    private String relation;
    private String job;
    private String telephone;
}

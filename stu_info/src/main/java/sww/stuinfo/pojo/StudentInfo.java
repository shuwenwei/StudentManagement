package sww.stuinfo.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentInfo {
    private String username;
    private String institute;
    private String major;
    private String grade;
    private String number;
    private UserInfo instructor;
}

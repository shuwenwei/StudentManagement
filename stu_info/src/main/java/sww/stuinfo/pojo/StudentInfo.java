package sww.stuinfo.pojo;

import lombok.Data;

@Data
public class StudentInfo {
    private String username;
    private String institute;
    private String major;
    private String grade;
    private String number;
    private UserInfo instructor;
}

package sww.stuinfo.pojo;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Clazz {

    private String id;
    private String number;
    private String studentNumber;
    private String grade;
    private String instructor;
    private String instructorId;
    private String major;
    private String majorId;

}

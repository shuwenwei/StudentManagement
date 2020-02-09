package sww.stuinfo.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Major {
    @NotNull
    @Pattern(regexp = "[0-9]{1,3}")
    private String id;
    @NotNull
    private String name;
    @Pattern(regexp = "[0-9]{1,3}")
    private String instituteId;
}

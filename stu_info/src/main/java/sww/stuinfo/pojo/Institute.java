package sww.stuinfo.pojo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
public class Institute {
    @Pattern(regexp = "[0-9]{1,3}")
    @NotNull
    private String id;
    @NotNull
    private String name;
}

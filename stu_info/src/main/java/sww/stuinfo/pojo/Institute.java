package sww.stuinfo.pojo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Institute {
    @Pattern(regexp = "[0-9]{1,3}")
    @NotBlank
    private String id;
    @NotBlank
    private String name;
}

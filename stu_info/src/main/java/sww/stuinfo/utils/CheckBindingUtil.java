package sww.stuinfo.utils;

import org.springframework.validation.BindingResult;
import sww.stuinfo.exception.IllegalPropertyException;

public class CheckBindingUtil {

    private CheckBindingUtil() {
    }

    public static void checkBinding(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getFieldError().getDefaultMessage();
            throw new IllegalPropertyException(message);
        }
    }
}

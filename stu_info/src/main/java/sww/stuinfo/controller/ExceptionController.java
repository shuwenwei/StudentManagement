package sww.stuinfo.controller;

import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import sww.stuinfo.exception.*;
import sww.stuinfo.pojo.DefaultResponseBean;


@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = LoginFailedException.class)
    public DefaultResponseBean loginFailed(LoginFailedException exception){
        return new DefaultResponseBean("登录失败",null,0);
    }

    @ExceptionHandler(value = UserNotExistException.class)
    public DefaultResponseBean userNotExist(UserNotExistException exception){
        return new DefaultResponseBean("该用户不存在",null,0);
    }

    @ExceptionHandler(value = UsernameTokenException.class)
    public DefaultResponseBean usernameToken(UsernameTokenException exception){
        return new DefaultResponseBean("用户名与token不符",null,0);
    }

    @ExceptionHandler(value = InvalidTokenException.class)
    public DefaultResponseBean badToken(InvalidTokenException exception){
        return new DefaultResponseBean("token错误或已过期",null,0);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(value = ShiroException.class)
    public DefaultResponseBean roleNotAllowed(ShiroException exception){
        return new DefaultResponseBean("无权访问",null,0);
    }

    @ExceptionHandler(value = InvalidFieldException.class)
    public DefaultResponseBean invalidField(InvalidFieldException exception){
        return new DefaultResponseBean("属性不存在",null,0);
    }

    @ExceptionHandler(value = IllegalPropertyException.class)
    public DefaultResponseBean illegalProperty(IllegalPropertyException exception){
        return new DefaultResponseBean("格式错误",exception.getFieldMessage(),0);
    }

    @ExceptionHandler(value = UsernameExistException.class)
    public DefaultResponseBean usernameExist(UsernameExistException exception){
        return new DefaultResponseBean("用户名已存在",null,0);
    }
}

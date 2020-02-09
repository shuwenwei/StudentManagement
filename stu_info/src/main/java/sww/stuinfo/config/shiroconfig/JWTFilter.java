package sww.stuinfo.config.shiroconfig;

import com.alibaba.fastjson.JSON;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import sww.stuinfo.pojo.DefaultResponseBean;
import sww.stuinfo.utils.JWTUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class JWTFilter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
        return true;
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws IOException {
        return true;
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        HttpServletRequest req = (HttpServletRequest) request;
        String token = req.getHeader("Authorization");
        if (token != null && !token.equals("")){
            String username = JWTUtils.getUsername(token);
            if (username != null){
//                放入的token变为username
                getSubject(request,response).login(new JWTToken(username));
                return super.isAccessAllowed(request,response,mappedValue);
            }else {
                String json = generateFailedJSON("ineffective token");
                try {
                    response.setContentType("application/json");
                    response.getWriter().write(json);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("token ineffective");
                return false;
            }
        }else {
            String json = generateFailedJSON("require login");
            try {
                response.getWriter().write(json);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        }
    }

    private String generateFailedJSON(String msg){
        DefaultResponseBean bean = new DefaultResponseBean(msg,null,0);
        return JSON.toJSONString(bean);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        return false;
    }

}

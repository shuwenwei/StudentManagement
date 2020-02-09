package sww.stuinfo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = {sww.stuinfo.config.DruidConfig.class,
        sww.stuinfo.config.shiroconfig.ShiroConfig.class})
public class MyConfig {

}

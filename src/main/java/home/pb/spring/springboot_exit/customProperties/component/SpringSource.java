package home.pb.spring.springboot_exit.customProperties.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration//为了不用在主启动程序中打上@EnableConfigurationProperties()标签，所以在此引入组件注解，这个也可以写上@Configuration注解
@ConfigurationProperties(prefix = "spring.datasource")
public class SpringSource {

    private String url;

    private String driver_class_name;

    private String username;

    private String password;

}

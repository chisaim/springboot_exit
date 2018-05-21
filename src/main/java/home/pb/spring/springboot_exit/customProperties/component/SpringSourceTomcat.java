package home.pb.spring.springboot_exit.customProperties.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "spring.datasource.tomcat")
public class SpringSourceTomcat {

    private String max_active;

    private String max_idle;

    private String min_idle;

    private String initial_size;

}

package home.pb.spring.springboot_exit.jersey.config;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;
import org.glassfish.jersey.servlet.ServletContainer;
import org.glassfish.jersey.servlet.ServletProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig{

    public JerseyConfig(){

        register(RequestContextFilter.class);
        //指定扫描的包路径
        packages("home.pb.spring.springboot_exit.jersey.controller");
    }

    @Bean
    public ServletRegistrationBean servletRegistrationBean(){

        ServletRegistrationBean bean = new ServletRegistrationBean(new ServletContainer(),"/jersey/*");

        bean.addInitParameter(ServletProperties.JAXRS_APPLICATION_CLASS,JerseyConfig.class.getName());

        return bean;

    }
}

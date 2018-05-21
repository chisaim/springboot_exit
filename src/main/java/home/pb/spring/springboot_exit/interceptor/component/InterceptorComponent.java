package home.pb.spring.springboot_exit.interceptor.component;

import home.pb.spring.springboot_exit.interceptor.MyInterceptor1;
import home.pb.spring.springboot_exit.interceptor.MyInterceptor2;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Component
public class InterceptorComponent extends WebMvcConfigurationSupport{

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor1());
        registry.addInterceptor(new MyInterceptor2());
    }

    @Override
    protected void configurePathMatch(PathMatchConfigurer configurer) {

        configurer.setUseTrailingSlashMatch(false);
        configurer.setUseSuffixPatternMatch(true);
    }
}

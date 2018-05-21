package home.pb.spring.springboot_exit;

import home.pb.spring.springboot_exit.customProperties.component.Email2Properties;
import home.pb.spring.springboot_exit.customProperties.component.EmailProperties;
import home.pb.spring.springboot_exit.customProperties.component.SpringSource;
import home.pb.spring.springboot_exit.interceptor.MyInterceptor1;
import home.pb.spring.springboot_exit.interceptor.MyInterceptor2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@ComponentScan(basePackages = {"home1.component"})
//@EnableConfigurationProperties(value = {Email2Properties.class, EmailProperties.class, SpringSource.class})
/*
@EnableAutoConfiguration
@Configuration
@ComponentScan
*/
@SpringBootApplication
public class SpringbootExitApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootExitApplication.class, args);
/*
		ApplicationContext ctx = SpringApplication.run(SpringbootExitApplication.class, new String[]{"SanSan","ErEr","ChiSaiM"});
//		String[] beans = ctx.getBeanDefinitionNames();//获取容器所有的加载对象
//			@Service
//			@Controller
//			@Repository
//			@Component
//			@Configuration
//			@RestController
		String[] beans = ctx.getBeanNamesForAnnotation(RestController.class);//获取容器中添加这此注解的所有对象
		int i = 0;
		for(String bean : beans){
			System.out.println(i++ + " : " + bean);
		}
*/
	}
}

package home1.component;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 引这个主启动类所在包包外的组件需要在主启动类上打@ComponentScan(basePackages = {"home1.component"})这个注解，
 * 同时需要引入其他注解
 */
@Component
public class PackageRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("This is PackageRunner.");
    }
}

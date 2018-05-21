package home.pb.spring.springboot_exit.condition.config;

import home.pb.spring.springboot_exit.condition.conditional.LinuxCondition;
import home.pb.spring.springboot_exit.condition.conditional.WindowCondition;
import home.pb.spring.springboot_exit.condition.service.CmdService;
import home.pb.spring.springboot_exit.condition.service.LinuxCmdService;
import home.pb.spring.springboot_exit.condition.service.WindowsCmdService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CmdServiceConditionConfig {

    @Bean("cmdService")
    @Conditional(WindowCondition.class)
    public CmdService windowCondition(){
        return new WindowsCmdService();
    }

    @Bean("cmdService")
    @Conditional(LinuxCondition.class)
    public CmdService linuxCondition(){
        return new LinuxCmdService();
    }

}

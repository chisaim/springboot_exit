package home.pb.spring.springboot_exit.autoTask.quarts_javaee_update.config;

import home.pb.spring.springboot_exit.autoTask.quarts_javaee_update.component.SpringBeanJobFactory;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {

    @Autowired
    private SpringBeanJobFactory springBeanJobFactory;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setJobFactory(springBeanJobFactory);
        return bean;
    }

    @Bean
    public Scheduler scheduler(){
        return schedulerFactoryBean().getScheduler();
    }

}

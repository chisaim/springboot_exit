package home.pb.spring.springboot_exit.autoTask.quartz_javaee.config;

import home.pb.spring.springboot_exit.autoTask.quartz_javaee.task_component.ScheduledTasks;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class ScheduledConfiguration {

    @Bean
    public MethodInvokingJobDetailFactoryBean detailFactoryBean(ScheduledTasks schedulerTasks){
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setTargetObject(schedulerTasks);
        bean.setTargetMethod("execute");
        return bean;
    }

    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(MethodInvokingJobDetailFactoryBean detailFactoryBean){
        CronTriggerFactoryBean bean = new CronTriggerFactoryBean();
        bean.setJobDetail(detailFactoryBean.getObject());
        bean.setCronExpression("0/5 * * ? * *");
        return bean;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean){
        SchedulerFactoryBean bean = new SchedulerFactoryBean();
        bean.setTriggers(cronTriggerFactoryBean.getObject());
        return bean;
    }
}

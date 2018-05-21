package home.pb.spring.springboot_exit.autoTask.quartz_starter_2_0.config;

import home.pb.spring.springboot_exit.autoTask.quartz_starter_2_0.quartz_job.MyJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyJobConfig {

    @Bean
    public JobDetail jobDetail(){
        return JobBuilder.newJob(MyJob.class)
                .usingJobData("name","sansan")
                .usingJobData("age",24)
                .withIdentity("job").storeDurably().build();
    }

    @Bean
    public Trigger myJobTrigger(){
        SimpleScheduleBuilder simpleScheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever();
        return TriggerBuilder.newTrigger().forJob(jobDetail()).withIdentity("myJobTrigger").withSchedule(simpleScheduleBuilder).build();
    }


}

package home.pb.spring.springboot_exit.autoTask.quarts_javaee_update.task;

import home.pb.spring.springboot_exit.autoTask.quarts_javaee_update.quartz_job.HelloJavaEEJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class QuartzJavaEEUpdateTask {

    @Autowired
    private Scheduler scheduler;

    @PostConstruct //等同于init-method
    public void init() throws SchedulerException {

        //创建具体任务
        JobDetail jobDetail = JobBuilder.newJob(HelloJavaEEJob.class).withIdentity("hello_job1","group1").build();

        //用这个类构建了执行时间，时间设定每5秒触发一次
        SimpleScheduleBuilder scheduleBuilder  = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();

        //创建时间触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("hello_trigger","first_trigger_group").withSchedule(scheduleBuilder).startNow().build();

        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }
}

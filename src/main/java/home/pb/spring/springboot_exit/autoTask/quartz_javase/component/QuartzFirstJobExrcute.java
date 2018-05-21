package home.pb.spring.springboot_exit.autoTask.quartz_javase.component;

import home.pb.spring.springboot_exit.autoTask.quartz_javase.quartz_job.HelloJavaSEJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Order(2)
public class QuartzFirstJobExrcute implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        /**
         * 这个执行方法之前是写在容器启动的主方法里面的，现在将其写成组件
         */
        System.out.println("scheduler.start.");
        //实例化一个任务调度器，并且开启调度器。
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();

        System.out.println(scheduler.getSchedulerName());
        //创建具体任务
        JobDetail jobDetail = JobBuilder.newJob(HelloJavaSEJob.class).withIdentity("hello_job1","group1").build();

        //用这个类构建了执行时间，时间设定每5秒触发一次
        SimpleScheduleBuilder scheduleBuilder  = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever();

        //创建时间触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("hello_trigger","first_trigger_group").withSchedule(scheduleBuilder).startNow().build();

        //调度器开始管理时间触发点和任务
        scheduler.scheduleJob(jobDetail,trigger);
        TimeUnit.SECONDS.sleep(20);
        scheduler.shutdown();
        System.out.println("scheduler.shutdown()...");
    }
}

package home.pb.spring.springboot_exit.autoTask.springtask.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;


@Configuration
@EnableScheduling
public class SpringTask {

    /**
     * 这个方法每10s打印一次
     */
    @Scheduled(cron = "0/10 * * * * *")
    public void task1(){
        System.out.println("SpringTask.task1()..");
    }

    /**
     * 这个方法每1分钟打印一次
     */
    @Scheduled(cron = "0 0/1 * * * *")
    public void task2(){
        System.out.println("SpringTask.task2()..");
    }

}

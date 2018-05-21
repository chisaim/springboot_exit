package home.pb.spring.springboot_exit.autoTask.springtask.curdtask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledFuture;

@RestController
@EnableScheduling
@RequestMapping("/dynamicTask")
public class DynamicTask {

    @Autowired
    private ThreadPoolTaskScheduler taskScheduler;

    private ScheduledFuture<?> future;

    @Bean
    public ThreadPoolTaskScheduler taskScheduler() {
        return new ThreadPoolTaskScheduler();
    }


    @RequestMapping("/startTask")
    public String startTask(){
        future = taskScheduler.schedule(new MyTask(), new CronTrigger("0 0/5 * * * *"));
        System.out.println("stratTask is success.");
        return "startTask";
    }

    @RequestMapping("/stopTask")
    public String stopTask(){
        if(future != null){
            future.cancel(true);
            System.out.println("stopTask is success.");
        }
        return "StopTask";
    }

    @RequestMapping("/changeCron")
    public String changeCron(){
        stopTask();
        future = taskScheduler.schedule(new MyTask(),new CronTrigger("0 0/5 * * * *"));
        System.out.println("changeCron is success.");
        return "changeCron";
    }

    private class MyTask implements Runnable{
        @Override
        public void run() {
            System.out.println("DynamicTask.myTask.run()...");
        }
    }
}

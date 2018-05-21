package home.pb.spring.springboot_exit.autoTask.springtask.cronchange;

import org.springframework.lang.Nullable;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@EnableScheduling
@RestController
@RequestMapping("/taskCronChange")
public class TaskCronChange implements SchedulingConfigurer{

    private String expression = "0 0/5 * * * *";

    @RequestMapping("/changeExpression")
    public String changeExpression(){
        expression = "0 0/5 * * * *";
        return "changeExpressionSuccess";
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        Runnable task = () -> System.out.println("TaskCronChange.run()...");

        Trigger trigger = new Trigger() {
            @Nullable
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                CronTrigger cronTrigger = new CronTrigger(expression);
                return cronTrigger.nextExecutionTime(triggerContext);
            }
        };

        scheduledTaskRegistrar.addTriggerTask(task,trigger);
    }
}

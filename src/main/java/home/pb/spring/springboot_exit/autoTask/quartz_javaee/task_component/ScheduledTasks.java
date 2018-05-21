package home.pb.spring.springboot_exit.autoTask.quartz_javaee.task_component;

import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
    public void execute(){System.out.println("ScheduledTasks.execute()...");}
}

package home.pb.spring.springboot_exit.autoTask.quarts_javaee_update.quartz_job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJavaEEJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz_job.HelloJavaEEJob.execute()...");
    }

}

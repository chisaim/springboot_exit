package home.pb.spring.springboot_exit.autoTask.quartz_javase.quartz_job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class HelloJavaSEJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz_job.HelloJavaSEJob.execute()...");
    }

}

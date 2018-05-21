package home.pb.spring.springboot_exit.autoTask.quartz_starter_2_0.service;

import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class QuartzJobManager {

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    public Date addJob(
            String jobName,
            String jobGroupName,
            String triggerName,
            String triggerGroupName,
            Class jobClass,
            String cronExpression
    ){
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName,jobGroupName).build();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity(triggerName,triggerGroupName).withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();

        try {
           return scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
            return null;
        }

    }

    public void deleteJob(
            String jobName,
            String jobGroupName,
            String triggerName,
            String triggerGroupName
    ){

        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,triggerGroupName);

        try {
            scheduler.pauseTrigger(triggerKey);

            JobKey jobKey = JobKey.jobKey(jobName,jobGroupName);

            scheduler.deleteJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


    public void modifyJobTime(
            String jobName,
            String jobGroupName,
            String triggerName,
            String triggerGroupName,
            String cronExpression
    ){
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        /**
         * 自动任务修改的简单方法，删除和再添加
        try {
            JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey(jobName,jobGroupName));

            deleteJob(jobName,jobGroupName,jobName,jobGroupName);

            addJob(jobName,jobGroupName,jobName,jobGroupName,jobDetail.getJobClass(),cronExpression);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        */

        TriggerKey triggerKey = TriggerKey.triggerKey(triggerName,triggerGroupName);

        try {
            CronTrigger cronTrigger = (CronTrigger) scheduler.getTrigger(triggerKey);

            String oldCronExpression = cronTrigger.getCronExpression();

            if(oldCronExpression.equals(cronExpression)){
                return;
            }

            cronTrigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).withSchedule(CronScheduleBuilder.cronSchedule(cronExpression)).build();

            scheduler.rescheduleJob(triggerKey,cronTrigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }


    public void startJob(){
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        try {
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public void shoutdownJob(){
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        try {
            if(!scheduler.isShutdown()){
                scheduler.shutdown();
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    public void standbyJob(){
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        try {
            scheduler.standby();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}

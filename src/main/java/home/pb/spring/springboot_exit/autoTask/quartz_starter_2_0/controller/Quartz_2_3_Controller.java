package home.pb.spring.springboot_exit.autoTask.quartz_starter_2_0.controller;

import home.pb.spring.springboot_exit.autoTask.quartz_starter_2_0.quartz_job.MyJob_2;
import home.pb.spring.springboot_exit.autoTask.quartz_starter_2_0.service.QuartzJobManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Quartz_2_3_Controller {

    @Autowired
    private QuartzJobManager quartzJobManager;


    @RequestMapping("/addJob")
    public String addJob(){
        quartzJobManager.addJob("myJob2"
                ,"myJob2Grp"
                ,"myJob2Trigger"
                ,"myJob2TriggerGrp"
                , MyJob_2.class
                ,"0/3 * * * * ?");
        return "addJobSuccess";
    }

    @RequestMapping("/deleteJob")
    public String deleteJob(){
        quartzJobManager.deleteJob("myJob2","myJob2Grp","myJob2Trigger","myJob2TriggerGrp");
        return "deleteJobSuccess";
    }

    @RequestMapping("/modifyJobTime")
    public String modifyJobTime(){
        quartzJobManager.modifyJobTime("myJob2","myJob2Grp","myJob2Trigger","myJob2TriggerGrp","0/10 * * * * ?");

        return "modifyJobTimeSuccess";
    }

    @RequestMapping("/startJob")
    public String startJob(){
        quartzJobManager.startJob();
        return "startJobSuccess";
    }

    @RequestMapping("/shoutdownJob")
    public String shoutdownJob(){
        quartzJobManager.shoutdownJob();
        return "shoutdownJobSuccess";

    }

    @RequestMapping("/standbyJob")
    public String standbyJob(){
        quartzJobManager.standbyJob();
        return "standbyJobSuccess";
    }

}

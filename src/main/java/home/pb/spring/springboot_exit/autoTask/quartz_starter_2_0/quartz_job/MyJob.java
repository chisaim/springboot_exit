package home.pb.spring.springboot_exit.autoTask.quartz_starter_2_0.quartz_job;

import home.pb.spring.springboot_exit.autoTask.quartz_starter_2_0.service.HelloService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class MyJob extends QuartzJobBean {

    /**
     * 这个服务在springboot2.0可直接注入，
     * 之前在1.0版本以前是需要配置的。
     * 这个项目中写了过多的自动任务，所以这个不会触发了。
     * 在quartz2.3.0的版本保重有自动任务的相关数据库表，2.2.3版中没有的。
     * 然后配上springboot-jpa和mysql-connector驱动包，application.properties配置上数据源。
     * 在数据库中就可以自动载入自动任务的相关信息数据。
     */
    @Autowired
    private HelloService service;

    private String name;

    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hello,Myjob :name-->" + this.name + " :age-->" + this.age);
        service.print();
    }
}

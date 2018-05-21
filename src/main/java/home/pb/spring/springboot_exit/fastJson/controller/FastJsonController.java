package home.pb.spring.springboot_exit.fastJson.controller;

import home.pb.spring.springboot_exit.entity.Demo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/fastJson")
public class FastJsonController {

    @RequestMapping("/getDemo")
    public Demo getDemo(){
        Demo demo = new Demo();
        demo.setName("sansan");
        demo.setCreateTime(new Date());
        return demo;
    }

}

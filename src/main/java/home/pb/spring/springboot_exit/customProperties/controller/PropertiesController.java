package home.pb.spring.springboot_exit.customProperties.controller;

import home.pb.spring.springboot_exit.customProperties.component.Email2Properties;
import home.pb.spring.springboot_exit.customProperties.component.EmailProperties;
import home.pb.spring.springboot_exit.customProperties.component.SpringSource;
import home.pb.spring.springboot_exit.customProperties.component.SpringSourceTomcat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PropertiesController {

    @Autowired
    private SpringSource springSource;

    @Autowired
    private SpringSourceTomcat springSourceTomcat;

    @Autowired
    private EmailProperties emailProperties;

    @Autowired
    private Email2Properties email2Properties;


    @RequestMapping("/getSpringSource")
    public SpringSource getSpringSource(){
        return springSource;
    }

    @RequestMapping("/getEmailProperties")
    public EmailProperties getEmailProperties(){
        return emailProperties;
    }

    @RequestMapping("/getEmail2Properties")
    public  Email2Properties getEmail2Properties(){
        return email2Properties;
    }

    @RequestMapping("/getAllProperties")
    public String getAllProperties(Model model){
        model.addAttribute("springSource",springSource);
        model.addAttribute("emailProperties",emailProperties);
        model.addAttribute("email2Properties",email2Properties);
        model.addAttribute("springSourceTomcat",springSourceTomcat);
        return "custom_properties_view";
    }

}

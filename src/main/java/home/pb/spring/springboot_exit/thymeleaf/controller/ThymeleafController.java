package home.pb.spring.springboot_exit.thymeleaf.controller;

import home.pb.spring.springboot_exit.entity.Customer;
import home.pb.spring.springboot_exit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ThymeleafController {

    @Autowired
    public CustomerService customerService;


    @RequestMapping("/thymeleaf_map")
    public String helloThymeleaf(Model model){
        Map<String,String> map = new HashMap<>();
        map.put("name1","sansan");
        model.addAttribute("simap",map);

        Customer customer = new Customer();
        customer.setAddress("精灵球第1号");
        model.addAttribute("customer",customer);

        Iterable<Customer> iterable = customerService.findAll();

        model.addAttribute("iterable",iterable);
        return "index_thymeleaf";
//        return new ModelAndView("index_thymeleaf");
    }

    @RequestMapping("/thymeleaf_hello")
    public String hello(Model map){

        Map<String,String> map1 = new HashMap<>();
        map1.put("name1","sansan");
        map.addAttribute("simap",map1);

        Customer customer = new Customer();
        customer.setAddress("精灵球第1号");
        map.addAttribute("customer",customer);


        Map user= new HashMap();
        user.put("name", "姓名");
        user.put("age", "年龄");
        user.put("sex", "性别");
        user.put("birthday", "生日");
        user.put("phonenumber", "手机");
        map.addAttribute("userhead", user);
        List userinfo =new ArrayList();
        userinfo.add("周美玲");
        userinfo.add("32");
        userinfo.add("女");
        userinfo.add("1985");
        userinfo.add("19850014665");
        map.addAttribute("userinfo", userinfo);
        List outerList=new ArrayList<>();
        Map innerMap=new HashMap<>();
        for (int i = 0; i < 10; i++) {
            innerMap.put("1", i);
            innerMap.put("1", i++);
            i++;
            outerList.add(innerMap);
        }
        map.addAttribute("listmap", outerList);
        return "index_thymeleaf";
    }
}

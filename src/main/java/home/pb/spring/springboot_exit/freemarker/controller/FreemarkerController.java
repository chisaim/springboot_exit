package home.pb.spring.springboot_exit.freemarker.controller;

import home.pb.spring.springboot_exit.entity.Customer;
import home.pb.spring.springboot_exit.service.CustomerService;
import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class FreemarkerController {

    @Autowired
    private CustomerService service;

    @RequestMapping("/freemarker_str")
    public String hello(Map<String,String> map){
        map.put("name","from freemarker");
        return "index_freemarker_str";
    }

    @RequestMapping("/freemarker_map")
    public String hello(Model model){
        Map<String,String> map = new HashMap<>();
        map.put("name","from freemarker");
        model.addAttribute("map",map);

        Customer customer = new Customer();
        customer.setAddress("1号机械城");
        model.addAttribute("customer",customer);

        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("BB");
        strings.add("CCC");
        strings.add("DDDD");
        strings.add("EEEEE");

        model.addAttribute("strList",strings);

        Iterable<Customer> customers = service.findAll();
        model.addAttribute("customers",customers);

        return "index_freemarker_map";
    }

}

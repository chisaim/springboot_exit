package home.pb.spring.springboot_exit.jpa.controller;

import home.pb.spring.springboot_exit.entity.Customer;
import home.pb.spring.springboot_exit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerComtroller {

    @Autowired
    public CustomerService customerService;

    @RequestMapping("/findAll")
    public Iterable<Customer> findAll(){
        return customerService.findAll();
    }

}

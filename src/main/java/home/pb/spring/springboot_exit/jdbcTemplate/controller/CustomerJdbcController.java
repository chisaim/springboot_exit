package home.pb.spring.springboot_exit.jdbcTemplate.controller;

import home.pb.spring.springboot_exit.jdbcTemplate.repository.CustomerDao;
import home.pb.spring.springboot_exit.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerJdbcController {

    @Autowired
    public CustomerDao customerDao;

    @RequestMapping("/findCustomerByCustomerName")
    public Customer findCustomerByCustomerName(String customerName){
        return customerDao.getCustomerByCustomerName(customerName);
    }

}

package home.pb.spring.springboot_exit.jersey.controller;


import home.pb.spring.springboot_exit.entity.Customer;
import home.pb.spring.springboot_exit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component
@Path("/customer")
//http://localhost:8080/jersey/customer/getJerseyCustomers访问地址上面的Path是必须存在的否则会报
//The resource configuration is not modifiable in this context.没有对应映射的问题。
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GET
    @Path("/getJerseyCustomers")
    @Produces(MediaType.APPLICATION_JSON)
    public Iterable<Customer> getCustomers(){

        return customerService.findAll();

    }

}

package home.pb.spring.springboot_exit.commandLineRunner.component;

import home.pb.spring.springboot_exit.entity.Customer;
import home.pb.spring.springboot_exit.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Order(1)
public class DataInitRunner implements CommandLineRunner {

    @Autowired
    private CustomerService service;

    @Override
    public void run(String... args) throws Exception { //这个地方的可变长参数args是主启动类中主方法中的参数传入
        if(service.count() == 0){
            for(int i=1 ;i<=1000;i++){
                Customer customer = new Customer();
                customer.setCustomerName("机器人第"+i+"号");
                customer.setAddress("精灵球第"+i+"号");
                customer.setCity(i+"号城市");
                customer.setProvince(i+"号省份");
                customer.setCreditLimit(i);
                customer.setPhone("电话:"+i);
                customer.setSaleEmployeeId(i);
                customer.setContactName("凹凸曼第"+i+"号");
                customer.setCreateDate(new Date());
                service.save(customer);
            }
        }
    }
}

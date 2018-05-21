package home.pb.spring.springboot_exit.jdbcTemplate.repository;

import home.pb.spring.springboot_exit.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Customer getCustomerByCustomerName(String customerName){
        String sql = "select * from site.t_customer where customerName = ?";
        RowMapper<Customer> rowMapper = new BeanPropertyRowMapper<>(Customer.class);
        return jdbcTemplate.queryForObject(sql,new Object[]{customerName},rowMapper);
    }

}

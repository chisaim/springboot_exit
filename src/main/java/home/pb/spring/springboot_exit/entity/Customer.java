package home.pb.spring.springboot_exit.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(schema = "site",name = "t_customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long customerId;

    @Column
    private String customerName;

    @Column
    private String contactName;

    @Column
    private String phone;

    @Column
    private String address;

    @Column
    private String province;

    @Column
    private String city;

    @Column
    private long saleEmployeeId;

    @Column
    private long creditLimit;

    @Column
    @JSONField(format = "yyyy-MM-dd")
    private Date createDate;
}

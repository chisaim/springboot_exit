package home.pb.spring.springboot_exit.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class Demo {

    private String name;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;


}

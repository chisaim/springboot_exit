package home.pb.spring.springboot_exit.webSocket.entity;

import lombok.Data;

@Data
public class SocketMsg {

    private int type;//0.群聊 1.单聊

    private String fromUser;//发送者

    private String toUser;//接受者 session.getid()

    private String msg;

}

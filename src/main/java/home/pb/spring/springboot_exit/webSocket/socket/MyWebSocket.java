package home.pb.spring.springboot_exit.webSocket.socket;

import com.fasterxml.jackson.databind.ObjectMapper;
import home.pb.spring.springboot_exit.webSocket.entity.SocketMsg;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

//这个组件注解注过的对象，会用单例模式创建出来的，但是还是会为每个MySocket连接初始化一个，所以下面才会出现静态Set集合来存储这个MyWebSocket
@Component
@ServerEndpoint(value = "/websocket/{nickname}")//websocket连接点映射
public class MyWebSocket {

    private static CopyOnWriteArraySet<MyWebSocket> webSockets = new CopyOnWriteArraySet<>();

    //用来记录sessionID和session之间的绑定关系
    private static Map<String, Session> map = new HashMap<>();

    private Session session;//当前会话的session

    private String nickname;

    /**
     * 连接成功调用的方法
     *
     * @param session
     */
    @OnOpen
    public void OnOpen(Session session,@PathParam("nickname") String nickname){
        this.nickname = nickname;
        this.session = session;
        map.put(session.getId(),session);
        webSockets.add(this);
//        this.session.getAsyncRemote().sendText("恭喜连接成功WebSocket-->当前在线人数为：" + webSockets.size());
        this.session.getAsyncRemote().sendText(nickname + "上线了,(你的频道号是"+session.getId()+")");
    }

    /**
     * 连接关闭调用的方法
     *
     * @param session
     */
    @OnClose
    public void OnClose(Session session){
        this.session = session;
        webSockets.remove(this);
        map.remove(session.getId());
    }

    @OnMessage
    public void OnMessage(String message,Session session,@PathParam("nickname") String nickname){

        try {
            SocketMsg socketMsg = new ObjectMapper().readValue(message,SocketMsg.class);
            //单聊
            if (socketMsg.getType() == 1) {
                //单聊实现，就是能够找到消息发送者和接受者
                socketMsg.setFromUser(session.getId());
//                socketMsg.setToUser(toUser);//这个是由客户端进行设置
                Session fromSession = map.get(socketMsg.getFromUser());
                Session toSession = map.get(socketMsg.getToUser());

                if(toSession != null){
                    fromSession.getAsyncRemote().sendText(nickname + ":" + socketMsg.getMsg());
                    toSession.getAsyncRemote().sendText(nickname + ":" + socketMsg.getMsg());
                }else{
                    fromSession.getAsyncRemote().sendText("系统消息：对方不在线或者您输入的频道有误");
                }
            } else {
                //群聊
                broadCast(socketMsg, nickname);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnError
    public void OnError(Session session, Throwable throwable) {
        System.out.println("There is a error");
    }

    /**
     * 群发的方法,其实就是循环遍历一遍上面的websocketSet
     *
     * @param socketMsg
     */
    private void broadCast(SocketMsg socketMsg, String nickname){
        for (MyWebSocket webSocket : webSockets){
            webSocket.session.getAsyncRemote().sendText(nickname + ":" + socketMsg.getMsg());
        }
    }

}

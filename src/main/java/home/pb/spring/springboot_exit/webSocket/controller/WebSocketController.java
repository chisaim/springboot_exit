package home.pb.spring.springboot_exit.webSocket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebSocketController {

    @RequestMapping("/WebSocketView")
    public String index(){
        return "websocket_view";
    }

}

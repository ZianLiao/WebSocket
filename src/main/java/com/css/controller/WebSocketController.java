package com.css.controller;

import com.css.service.WebSocket;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@RestController
@RequestMapping("/test")
public class WebSocketController {
    @Autowired
    WebSocket webSocket;

    //    @ResponseBody
    @SneakyThrows
    @GetMapping("/sendTo")
    public String sendTo(@RequestParam("userId") String userId, @RequestParam("msg") String msg) throws IOException {

        webSocket.sendMessageTo(msg,userId);

        return "推送成功";
    }


    @GetMapping("/sendAll")
    public String sendAll(@RequestParam("msg") String msg) throws IOException {

        String fromUserId="system";
        webSocket.sendMessageAll(msg,fromUserId);

        return "群发推送成功";
    }
}

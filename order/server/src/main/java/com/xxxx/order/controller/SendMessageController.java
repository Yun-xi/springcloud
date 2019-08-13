package com.xxxx.order.controller;

import com.xxxx.order.message.StreamClient;
import com.xxxx.order.message.StreamSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SendMessageController {

    @Autowired
    private StreamSender streamSender;

    @GetMapping("/sendMsg")
    public void send(){
        streamSender.sendProcess();
    }
}

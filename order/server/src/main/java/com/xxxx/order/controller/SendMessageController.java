package com.xxxx.order.controller;

import com.xxxx.order.dto.OrderDTO;
import com.xxxx.order.message.StreamClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
public class SendMessageController {

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendMsg")
    public void send(){
        Message<String> message = MessageBuilder.withPayload("now " + new Date()).build();
        streamClient.output().send(message);
    }

    /**
     * 发送OrderDTO对象
     */
    @GetMapping("/sendMessage")
    public void process(){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setOrderId("123456");
        Message<OrderDTO> message = MessageBuilder.withPayload(orderDTO).build();
        streamClient.output().send(message);
    }
}

package com.xxxx.order.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class StreamSender {

    @Autowired
    private StreamClient streamClient;

    public void sendProcess(){
        String message = "now " + new Date();
        streamClient.output().send(MessageBuilder.withPayload(message).build());
    }
}

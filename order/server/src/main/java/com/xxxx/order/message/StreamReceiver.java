package com.xxxx.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @StreamListener("outputBinding")
    @SendTo("outputBinding2")
    public void process(Object message){
        log.info("StreamReceiver2: {}" + message);
    }
}

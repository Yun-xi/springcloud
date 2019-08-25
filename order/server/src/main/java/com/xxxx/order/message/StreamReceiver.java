package com.xxxx.order.message;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import static com.xxxx.order.message.StreamClient.*;

/**
 * @author xieyaqi
 * @mail xieyaqi11@gmail.com
 * @date 2019-08-23 17:51
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    @SendTo(OUTPUT_MESSAGE2)
    @StreamListener(INPUT_MESSAGE)
    public String process(Object message) {
        log.info("StreamReceiver: {}", message);
        // 发送mq消息
        return "received.";
    }

    @StreamListener(INPUT_MESSAGE2)
    public void process2(Object message) {
        log.info("StreamReceiver2: {}", message);
    }

}

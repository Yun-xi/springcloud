package com.xxxx.order;

import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author xieyaqi
 * @mail xieyaqi11@gmail.com
 * @date 2019-08-22 10:13
 */
@Component
public class MqSenderTest extends OrderApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /*@Test
    public void send() {
        amqpTemplate.convertAndSend("myQueue", "now " + new Date());

    }*/

    @Test
    public void send() {
        amqpTemplate.convertAndSend("myOrder", "fruit", "now " + new Date());

    }
}

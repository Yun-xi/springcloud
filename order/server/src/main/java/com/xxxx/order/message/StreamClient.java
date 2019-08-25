package com.xxxx.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * @author xieyaqi
 * @mail xieyaqi11@gmail.com
 * @date 2019-08-23 17:23
 */
public interface StreamClient {

    String INPUT_MESSAGE = "input_message";
    String INPUT_MESSAGE2 = "input_message2";
    String OUTPUT_MESSAGE = "output_message";
    String OUTPUT_MESSAGE2 = "output_message2";

    @Input(INPUT_MESSAGE)
    SubscribableChannel input();

    @Input(INPUT_MESSAGE2)
    SubscribableChannel input2();

    @Output(OUTPUT_MESSAGE)
    MessageChannel output();

    @Output(OUTPUT_MESSAGE2)
    MessageChannel output2();
}

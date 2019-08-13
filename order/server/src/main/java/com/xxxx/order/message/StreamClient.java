package com.xxxx.order.message;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface StreamClient {

    String MESSAGE = "myMessage";

    @Input("inputBinding")
    SubscribableChannel input();

    @Output("outputBinding")
    MessageChannel output();
}

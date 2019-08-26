package com.xxxx.order.message;

import com.xxxx.order.utils.JsonUtil;
import com.xxxx.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author xieyaqi
 * @mail xieyaqi11@gmail.com
 * @date 2019-08-26 13:47
 */
@Slf4j
@Component
public class ProductInfoReceiver {

    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        // message => ProductInfoOutput
        ProductInfoOutput productInfoOutput = (ProductInfoOutput)JsonUtil.fromJson(message, ProductInfoOutput.class);
        log.info("从队列 {} 接收到消息: {}", "productInfo", productInfoOutput);

        // 存到redis

    }
}

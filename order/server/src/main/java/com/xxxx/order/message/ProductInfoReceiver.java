package com.xxxx.order.message;

import com.fasterxml.jackson.core.type.TypeReference;
import com.xxxx.order.utils.JsonUtil;
import com.xxxx.product.common.ProductInfoOutput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xieyaqi
 * @mail xieyaqi11@gmail.com
 * @date 2019-08-26 13:47
 */
@Slf4j
@Component
public class ProductInfoReceiver {

    private static final String PRODUCT_STOCK_TEMPLATE = "product:stock:%s";
    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @RabbitListener(queuesToDeclare = @Queue("productInfo"))
    public void process(String message) {
        // message => ProductInfoOutput
        List<ProductInfoOutput> productInfoOutputList = (List<ProductInfoOutput>)JsonUtil.fromJson(message, new TypeReference<List<ProductInfoOutput>>(){});
        log.info("从队列 {} 接收到消息: {}", "productInfo", productInfoOutputList);

        // 存到redis
        for (ProductInfoOutput productInfoOutput : productInfoOutputList) {
            stringRedisTemplate.opsForValue().set(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput), String.valueOf(productInfoOutput.getProductStock()));
            String s = stringRedisTemplate.opsForValue().get(String.format(PRODUCT_STOCK_TEMPLATE, productInfoOutput));
            System.out.println(s);
        }
    }
}

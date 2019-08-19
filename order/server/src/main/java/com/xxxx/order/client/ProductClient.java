package com.xxxx.order.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * feign使用三步骤：
 * 1.引入包：<dependency>
 *             <groupId>org.springframework.cloud</groupId>
 *             <artifactId>spring-cloud-starter-openfeign</artifactId>
 *         </dependency>
 *
 * 2.在启动类上加入@EnableFeignClients
 *
 * 3.在接口上声明@FeignClient(name = "product")
 *   在方法上声明@GetMapping("/msg")
 *
 */
@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/msg")
    String productMsg();
}

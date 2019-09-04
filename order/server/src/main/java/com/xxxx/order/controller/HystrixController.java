package com.xxxx.order.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @author xieyaqi
 * @mail xieyaqi11@gmail.com
 * @date 2019-09-04 15:24
 */
@RestController
@DefaultProperties(defaultFallback = "defaultFallback")
public class HystrixController {

    // 超时配置
//    @HystrixCommand(fallbackMethod = "fallback", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
//    @HystrixCommand(commandProperties = {
//            // 开启熔断
//            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
//            // 滚动时间窗口中，断路器最小请求数，如果收到请求为9个，即时这9个请求都失败，也不会打开断路器
//            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
//            // 当短路器打开对主逻辑进行熔断之后，会启动一个休眠时间窗，在这个时候降级逻辑就会成为主逻辑，当休眠时间窗到期之后，会进入half open（半打开状态），释放一次请求到之前的主逻辑上面，
//            // 如果请求正常返回，那么断路器就会闭合，主逻辑恢复，如果这次请求依然失败，那么断路器打开，休眠时间窗重新开始计时
//            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
//            // 断路器打开的错误百分比条件，如果错误率>=该值，就会打开断路器，比如在滚动时间窗口中，如果有10次请求，17次以上的异常，这时候断路器就会被设置为打开状态
//            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")})
    @HystrixCommand
    @GetMapping("/getProductInfoList")
    public String getProductInfoList() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8081/product/listForOrder",
                Arrays.asList("157875196366160022"),
                String.class);

//        throw new RuntimeException("发送一次了");
    }

    private String fallback() {
        return "太拥挤了，请稍后再试~~";
    }

    private String defaultFallback() {
        return "默认提示：太拥挤了，请稍后再试~~";
    }
}

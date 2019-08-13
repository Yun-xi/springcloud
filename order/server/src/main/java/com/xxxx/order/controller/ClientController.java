package com.xxxx.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
public class ClientController {

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        // 1.第一种方式
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("http://localhost:8081/msg", String.class);

        log.info("response: {}", response);
        return response;
    }
}

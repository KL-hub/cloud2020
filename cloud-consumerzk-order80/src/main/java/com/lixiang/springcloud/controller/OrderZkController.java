package com.lixiang.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/4/25
 * @Version 1.0
 */
@RestController
@Slf4j
public class OrderZkController {

    public static final String URL ="http://cloud-provider-payment";
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/order")
    public String  paymentInfo(){
        String result=restTemplate.getForObject(URL+"/payment/zk",String.class);
        return result;
    }

}

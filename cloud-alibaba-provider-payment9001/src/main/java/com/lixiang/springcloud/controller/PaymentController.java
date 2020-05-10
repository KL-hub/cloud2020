package com.lixiang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/10
 * @Version 1.0
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos/{id}")
    public String getPayment(@PathVariable(value = "id")Long id){
        return "nacos register"+serverPort +"\t"+id;
    }
}

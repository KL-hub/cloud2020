package com.lixiang.springcloud.controller;

import com.lixiang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/5
 * @Version 1.0
 */
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("$(server.port)")
    private String serverPort;

    @GetMapping(value="/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable Integer id){
        return paymentService.paymentInfo_OK(id);
    }

    @GetMapping(value="/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable Integer id){
        return paymentService.paymentInfo_Timeout(id);
    }
}

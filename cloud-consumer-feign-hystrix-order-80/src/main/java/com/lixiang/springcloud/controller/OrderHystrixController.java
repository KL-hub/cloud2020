package com.lixiang.springcloud.controller;

import com.lixiang.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback="fallback")
public class OrderHystrixController {
    @Resource
    private OrderHystrixService orderHystrixService;

    @GetMapping(value="/consumer/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable(value = "id") Integer id){
       return orderHystrixService.payment_ok(id);
    }

    @GetMapping(value="/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_handler",commandProperties = {
//            @HystrixProperty(name  ="execution.isolation.thread.timeoutInMilliseconds" ,value = "1500")
//    })
    @HystrixCommand
    public String paymentInfo_Timeout(@PathVariable(value = "id") Integer id){
        int age=1/0;
        return orderHystrixService.paymentInfo_Timeout(id);
    }
    public String paymentInfo_Timeout_handler(Integer id){
        return "线程池"+Thread.currentThread().getName() + " paymentInfo_TimeoutHandle";
    }
    public String fallback(){
        return "全局异常";
    }
}

package com.lixiang.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/5
 * @Version 1.0
 */
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT" ,fallback = PaymentFallBackService.class)
@Component
public interface OrderHystrixService {
    @GetMapping(value="/payment/hystrix/ok/{id}")
    public String payment_ok(@PathVariable(value = "id") Integer id);

    @GetMapping(value="/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable(value = "id") Integer id);

}

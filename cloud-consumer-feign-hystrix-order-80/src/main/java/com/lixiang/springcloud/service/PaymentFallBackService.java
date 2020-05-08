package com.lixiang.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/5
 * @Version 1.0
 */
@Component
public class PaymentFallBackService implements OrderHystrixService {
    @Override
    public String payment_ok(Integer id) {
        return "PaymentFallBackService-------------payment_ok 异常";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "PaymentFallBackService-------------paymentInfo_Timeout 异常";
    }
}

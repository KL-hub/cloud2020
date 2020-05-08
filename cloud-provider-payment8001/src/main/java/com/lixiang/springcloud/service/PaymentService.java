package com.lixiang.springcloud.service;

import com.lixiang.springcloud.entities.Payment;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/4/24
 * @Version 1.0
 */
public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}

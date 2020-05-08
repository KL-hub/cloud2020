package com.lixiang.springcloud.service.impl;

import com.lixiang.springcloud.dao.PaymentDao;
import com.lixiang.springcloud.entities.Payment;
import com.lixiang.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/4/24
 * @Version 1.0
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}

package com.lixiang.springcloud.dao;

import com.lixiang.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;


/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/4/24
 * @Version 1.0
 */
@Mapper
public interface PaymentDao {
    int create(Payment payment);
    Payment getPaymentById(Long id);
}

package com.lixiang.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/5
 * @Version 1.0
 */
@Service
public class PaymentService {
    public String paymentInfo_OK(Integer id){
        return "线程池"+Thread.currentThread().getName() + " paymentInfo_OK";
    }

    /**
     * 超时
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfo_Timeout_handler",commandProperties = {
            @HystrixProperty(name  ="execution.isolation.thread.timeoutInMilliseconds" ,value = "5000")
    })
    public String paymentInfo_Timeout(Integer id){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){

        }
        return "线程池"+Thread.currentThread().getName() + " paymentInfo_Timeout";
    }
    public String paymentInfo_Timeout_handler(Integer id){
        return "线程池"+Thread.currentThread().getName() + " paymentInfo_TimeoutHandle";
    }
}

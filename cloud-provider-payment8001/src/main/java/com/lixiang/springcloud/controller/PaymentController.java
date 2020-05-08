package com.lixiang.springcloud.controller;

import com.lixiang.springcloud.entities.CommonResult;
import com.lixiang.springcloud.entities.Payment;
import com.lixiang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/4/24
 * @Version 1.0
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(Payment payment){
        int i = paymentService.create(payment);
       // log.info("*********:port{}",serverPort);
        if(i>0){
            return new CommonResult(200,"插入数据成功，port"+serverPort,i);
        }else {
            return new CommonResult(444,"插入数据失败, port"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        //log.info("payment8001 id:{}",id);
        System.out.println("-----------------"+id);
        Payment payment = paymentService.getPaymentById(id);
        if(payment!=null){
            return new CommonResult(200,"查询数据成功 ,port "+serverPort,payment);
        }else {
            return new CommonResult(444,"查询数据失败, port "+serverPort,null);
        }
    }
    //服务发现
    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("******element"+service);
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for (ServiceInstance instance : instances) {
                log.info("instanceId:{}",instance.getInstanceId());
                log.info("host:{}",instance.getHost());
                log.info("port:{}",instance.getPort());
            }
            
        }
        return this.discoveryClient;
    }

}

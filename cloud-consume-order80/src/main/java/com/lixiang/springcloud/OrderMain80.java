package com.lixiang.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @Description //服务消费者
 * @Author 李项
 * @Date 2020/4/25
 * @Version 1.0
 */
@EnableEurekaClient
@SpringBootApplication
@RibbonClients
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}

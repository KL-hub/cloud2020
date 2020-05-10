package com.lixiang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/10
 * @Version 1.0
 */
@RestController
@RefreshScope
public class InfoController {
    @Value("${config.info}")
    private String config;

    @GetMapping(value = "/info")
    public String getInfo(){
        return config;
    }
}

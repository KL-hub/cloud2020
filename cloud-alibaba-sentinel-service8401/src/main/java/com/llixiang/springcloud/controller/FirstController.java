package com.llixiang.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/10
 * @Version 1.0
 */
@RestController
public class FirstController {

    @GetMapping(value = "/test")
    public String getInfo() {
        return "test";
    }
}

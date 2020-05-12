package com.llixiang.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/10
 * @Version 1.0
 */
@RestController
public class FirstController {

    @GetMapping(value = "/testA")
    public String getInfo() {
        return "testA";
    }

    @GetMapping(value = "/testB")
    public String getInfoB() {
        return "testB";
    }

    @GetMapping(value = "/testE")
    @SentinelResource(value = "testHotKey" ,blockHandler = "deal_testHotKey")
    public String getInfoE(@RequestParam(required = false) String p1,@RequestParam (required = false)String p2) {

        return "testE";
    }
    public String deal_testHotKey(String p1, String p2, BlockException exception){
        return "deal_testHotKey";
    }
}

package com.llixiang.springcloud.controller;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lixiang.springcloud.entities.CommonResult;
import com.lixiang.springcloud.entities.Payment;
import com.llixiang.springcloud.myHandle.CustomerBlockHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import	java.util.ResourceBundle;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/12
 * @Version 1.0
 */
@RestController
public class FlowLimitController {
    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "deal_byResource")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流",new Payment(100L,""));
    }
    public CommonResult deal_byResource(BlockException block){
        return new CommonResult(500,"限流了","");
    }
    //CustomerBlockHandler
    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
            blockHandlerClass = CustomerBlockHandler.class,blockHandler = "handlerException2")
    public CommonResult customerBlockHandler() {
        return  new CommonResult(200,"按照客户自定义限流测试",new Payment(2020L,"serial003"));
    }

}

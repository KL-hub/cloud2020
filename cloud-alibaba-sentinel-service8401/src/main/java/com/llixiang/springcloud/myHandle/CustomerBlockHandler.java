package com.llixiang.springcloud.myHandle;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lixiang.springcloud.entities.CommonResult;
import com.lixiang.springcloud.entities.Payment;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/12
 * @Version 1.0
 */
public class CustomerBlockHandler {

    public static CommonResult handlerException(BlockException exception) {
        return  new CommonResult(444,"按照客户自定义的Glogal 全局异常处理 ---- 1",new Payment(2020L,"serial003"));
    }

    public static CommonResult handlerException2(BlockException exception) {
        return  new CommonResult(444,"按照客户自定义的Glogal 全局异常处理 ---- 2",new Payment(2020L,"serial003"));
    }
}
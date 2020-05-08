package com.lixiang.springcloud.service.impl;

import com.lixiang.springcloud.service.IMessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/8
 * @Version 1.0
 */
@EnableBinding(Source.class)  //定义消息的推送管道
public class MessageProviderImpl  implements IMessageProvider {

    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        String serial= UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        return null;
    }
}

package com.lixiang.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/7
 * @Version 1.0
 */
@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("*********");
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        //Assert.hasLength(username,"用户名不能为空");
        if(username == null){
            log.info("非法用户");
           exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
           return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

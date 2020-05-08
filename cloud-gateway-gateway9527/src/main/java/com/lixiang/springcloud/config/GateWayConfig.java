package com.lixiang.springcloud.config;

import lombok.Builder;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description //TODO
 * @Author 李项
 * @Date 2020/5/5
 * @Version 1.0
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_lixiang",p -> p.path("/guonei")
        .uri("http://www.baidu.com")).build();
        return routes.build();
    }
}

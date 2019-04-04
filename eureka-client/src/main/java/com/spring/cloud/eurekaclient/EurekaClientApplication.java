package com.spring.cloud.eurekaclient;

import com.netflix.discovery.DiscoveryClient;
import com.netflix.eureka.registry.ResponseCacheImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 注：@SpringBootApplication注解只会扫描当前包及其子包
 * 注解@EnableEurekaClient声明该程序为Eureka客户端
 */
@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    public static void main(String[] args) {
        DiscoveryClient client;
        ResponseCacheImpl responseCacheImpl;
        SpringApplication.run(EurekaClientApplication.class, args);
    }

}

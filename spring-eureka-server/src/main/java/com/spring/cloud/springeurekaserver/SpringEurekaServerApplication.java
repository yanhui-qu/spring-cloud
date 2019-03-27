package com.spring.cloud.springeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 注：@SpringBootApplication注解只会扫描当前包及其子包
 * 注解@EnableEurekaServer声明该程序为Eureka客户服务端
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEurekaServerApplication.class, args);
    }

}

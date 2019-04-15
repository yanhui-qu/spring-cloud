package spring.cloud.springeurekaserverhia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.eureka.server.EurekaServerBootstrap;

/**
 * 注：@SpringBootApplication注解只会扫描当前包及其子包
 * 注解@EnableEurekaServer声明该程序为Eureka客户服务端
 * spring-eureka-server-hia是高可用集群搭建，
 * spring-eureka-server是单个eureka服务
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringEurekaServerHiaApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringEurekaServerHiaApplication.class, args);
    }

}

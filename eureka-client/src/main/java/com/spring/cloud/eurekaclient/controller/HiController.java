package com.spring.cloud.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HiController {
    @Value("${server.port}")
    String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/hi")
    public String hello(@RequestParam String name){

        return "name:" + name + ", port:" + port;
    }

    @GetMapping("/user-instance")
    public void getUserInstance(){
        List<ServiceInstance> instances = discoveryClient.getInstances("eureka-client");
        for (int i = 0; i < instances.size(); i++) {
            ServiceInstance instance = instances.get(i);
        }
    }
}

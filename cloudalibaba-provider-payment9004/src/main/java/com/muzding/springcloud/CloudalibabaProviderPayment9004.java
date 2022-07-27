package com.muzding.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudalibabaProviderPayment9004 {
    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaProviderPayment9004.class, args);
        System.out.println("启动成功");
    }
}

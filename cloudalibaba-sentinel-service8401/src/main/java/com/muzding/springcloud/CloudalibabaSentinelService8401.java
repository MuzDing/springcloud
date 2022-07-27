package com.muzding.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CloudalibabaSentinelService8401 {
    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaSentinelService8401.class, args);
        System.out.println("service is ok...");
    }

}


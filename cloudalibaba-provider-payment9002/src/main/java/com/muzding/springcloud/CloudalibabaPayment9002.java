package com.muzding.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaPayment9002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudalibabaPayment9002.class,args);
        System.out.println("service is ok....");
    }
}

package com.muzdin.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudGateWayMain6001 {
    public static void main(String[] args) {
        SpringApplication.run(CloudGateWayMain6001.class, args);
    }
}

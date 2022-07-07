package com.muzding.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EuerkaMain7001 {
    public static void main(String[] args) {
        SpringApplication.run(EuerkaMain7001.class,args);
        System.out.println("service is ok...");
    }
}

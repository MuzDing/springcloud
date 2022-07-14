package com.muzding.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author muzding
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344{

    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class, args);
        System.out.println("启动成功");

    }

}
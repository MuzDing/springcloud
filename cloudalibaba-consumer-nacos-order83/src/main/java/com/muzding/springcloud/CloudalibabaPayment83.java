package com.muzding.springcloud;

import com.alibaba.nacos.api.exception.NacosException;
import com.alibaba.nacos.api.naming.NamingFactory;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.api.naming.listener.Event;
import com.alibaba.nacos.api.naming.listener.EventListener;
import com.alibaba.nacos.api.naming.listener.NamingEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.Properties;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudalibabaPayment83 {
    public static void main(String[] args) throws NacosException {
        SpringApplication.run(CloudalibabaPayment83.class,args);
        System.out.println("service is ok....");

    }
}

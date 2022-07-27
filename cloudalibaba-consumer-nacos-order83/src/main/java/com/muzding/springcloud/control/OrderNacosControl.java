package com.muzding.springcloud.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class OrderNacosControl {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverUrl;

    @GetMapping(value = "/consumer/payment/nacos")
    public String paymentInfo(@RequestParam("id") Integer id) {
        return restTemplate.getForObject(serverUrl + "/payment/nacos?id=" + id ,String.class);
    }
}

package com.muzding.springcloud.control;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentControl {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/nacos")
    public String getPayment(@RequestParam Integer id) {
        return "nacos registry, serverPort: " + serverPort + "\t id" + id;
    }
}

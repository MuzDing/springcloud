package com.muzding.springcloud.control;

import com.muzding.springcloud.entity.Payment;
import com.muzding.springcloud.service.PaymentService;
import com.muzding.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
public class PaymentControl {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    // 服务发现
    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/createPay",method = RequestMethod.POST)
    public CommonResult createPay(@RequestParam String id , @RequestParam String serial){
        System.out.println(id + serial);
        Payment payMent = new Payment(Long.parseLong(id),serial);
        paymentService.insertPayment(payMent);

        return new CommonResult(1,"插入数据库成功" + serverPort,null);
    }

    @RequestMapping(value = "/fingPaymentByid",method = RequestMethod.GET)
    public CommonResult fingPaymentByid(@RequestParam Long id){
        log.info("查询成功");
        return new CommonResult(1,"查询成功" + serverPort,paymentService.fingPaymentByid(id));
    }

    @RequestMapping(value = "/discovery",method = RequestMethod.GET)
    public CommonResult discovery(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        log.info("查询成功");
        return new CommonResult(1,"查询成功 " + serverPort ,instances);
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String createPay1(@RequestParam String serial){
        return serial;
    }
}
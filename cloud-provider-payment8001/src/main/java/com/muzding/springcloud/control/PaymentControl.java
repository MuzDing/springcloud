package com.muzding.springcloud.control;

import com.muzding.springcloud.entity.Payment;
import com.muzding.springcloud.service.PaymentService;
import com.muzding.springcloud.entity.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @RequestMapping(value = "/findPaymentByid",method = RequestMethod.GET)
    public CommonResult findPaymentByid(@RequestParam Long id){
        log.info("查询成功");
        return new CommonResult(1,"查询成功 " + serverPort ,paymentService.findPaymentByid(id));
    }

    @RequestMapping(value = "/discovery",method = RequestMethod.GET)
    public CommonResult discovery(){
        List<String> services = discoveryClient.getServices();
        log.info("查询成功");
        return new CommonResult(1,"查询成功 " + serverPort ,services);
    }

    @RequestMapping(value = "/payment/feign/timeout",method = RequestMethod.GET)
    public String paymentFeignTimeOut(){
        log.info("8001被调用");
        try{
            TimeUnit.SECONDS.sleep(6);
        }catch (Exception e){
            e.printStackTrace();
        }
        return serverPort;
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String createPay1(@RequestParam String serial){
        return serial;
    }

    @GetMapping("/payment/zipkin")
    public String paymentZipkin(){
        return "hi , i am paymentzipkin server fall back,welcome to muzding";
    }
}

package com.muzding.springcloud.control;

import com.muzding.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymentControl {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/hystrix/payment/ok" ,method = RequestMethod.GET)
    public String paymentInfo_OK(@RequestParam Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("********result + " + result);
        return result;
    }

    @RequestMapping(value = "/hystrix/payment/Timeout")
    public String paymentInfo_Timeout(@RequestParam Integer id){
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("********result + " + result);
        return result;
    }
}

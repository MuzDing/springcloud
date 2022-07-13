package com.muzding.springcloud.sercice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {

    @RequestMapping(value = "/hystrix/payment/ok" ,method = RequestMethod.GET)
    public String paymentInfoOK(@RequestParam("id") Integer id);

    @RequestMapping(value = "/hystrix/payment/Timeout")
    public String paymentInfoTimeout(@RequestParam("id") Integer id);
}
